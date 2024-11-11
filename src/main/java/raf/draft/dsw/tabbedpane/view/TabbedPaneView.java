package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Data
public class TabbedPaneView extends JTabbedPane {
    public TabbedPaneView() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
    public void initialize(HashMap<DraftNode,TabPanel> tabovi){
        if(tabovi == null) return;
        removeAll();
        String label,punNaziv;
        for(Map.Entry<DraftNode,TabPanel> child: tabovi.entrySet()) {
            TabPanel tabPanel = child.getValue();
            tabPanel.removeAll();
            if(tabPanel.getRoom().getRoditelj() instanceof Project)
            {
                label = tabPanel.getRoom().getRoditelj().getNaziv() + "/";
                punNaziv = tabPanel.getRoom().getNaziv();
            }
            else{
                label = tabPanel.getRoom().getRoditelj().getRoditelj().getNaziv() + "/" + tabPanel.getRoom().getRoditelj().getNaziv();
                punNaziv = String.format("%s/%s", tabPanel.getRoom().getRoditelj().getNaziv(),tabPanel.getRoom().getNaziv());
            }
            tabPanel.add(new JLabel(label));
            addTab(punNaziv, tabPanel);
        }
        for(int i=0; i<getTabCount(); i++){
            setBackgroundAt(i,((TabPanel)getComponentAt(i)).getRoom().getColor());
            setForegroundAt(i, ColorUtils.getContrastingTextColor(((TabPanel) getComponentAt(i)).getRoom().getColor()));
        }
    }


}
