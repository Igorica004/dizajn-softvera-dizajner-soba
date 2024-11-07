package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.ProzorNoviProjekatForma;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class NoviProjekatFormaAkcija extends AbstractRoomAction{

    public NoviProjekatFormaAkcija() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstanca().getDraftTree().getSelectedNode();
        ProzorNoviProjekatForma forma = new ProzorNoviProjekatForma();
        forma.setVisible(true);
    }
    public Project getProject(){
        ProzorNoviProjekatForma prozorNoviProjekatForma = new ProzorNoviProjekatForma();
        prozorNoviProjekatForma.setVisible(true);
        return prozorNoviProjekatForma.getProject();
    }
}
