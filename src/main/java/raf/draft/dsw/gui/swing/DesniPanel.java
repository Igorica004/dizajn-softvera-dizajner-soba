package raf.draft.dsw.gui.swing;

import lombok.Data;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.TabbedPaneInterface;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.utils.JPanelUtils;

import javax.swing.*;

@Data
public class DesniPanel extends JPanel implements ISubscriber {
    TabbedPaneInterface tabbedPane = new TabbedPaneImplementation();
    private JLabel naziv = new JLabel();
    private JLabel autor = new JLabel();

    public DesniPanel() {
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(JPanelUtils.makeHBox(
                new JLabel("Naziv: "),
                naziv
        ));
        add(JPanelUtils.makeHBox(
                new JLabel("Autor: "),
                autor
        ));
        add(((TabbedPaneImplementation)tabbedPane).getTabbedPaneView());
    }

    @Override
    public void update(Notification notification) {
        tabbedPane.updateTabbedPane();
        DraftTreeImplementation draftTreeImplementation = (DraftTreeImplementation) MainFrame.getInstanca().getDraftTree();
        DraftNode selektovan = draftTreeImplementation.getSelectedNode().getDraftNode();
        Project projekat = null;
        if(selektovan instanceof Project project) {projekat = project;}
        else if(selektovan instanceof Building building) {projekat = (Project)building.getRoditelj();}
        if(projekat == null) {return;}
        naziv.setText(projekat.getNaziv());
        autor.setText(projekat.getAutor());
    }
}
