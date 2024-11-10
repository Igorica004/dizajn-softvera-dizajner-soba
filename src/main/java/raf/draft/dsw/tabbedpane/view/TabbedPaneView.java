package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.utils.ColorUtils;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

@Data
public class TabbedPaneView extends JTabbedPane {
    public TabbedPaneView() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
    public void initialize(ArrayList<TabPanel> tabovi){
        if(tabovi == null) return;
        removeAll();
        String label;
        for(TabPanel child : tabovi) {
            child.removeAll();
            if(child.getRoom().getRoditelj() instanceof Project)
            {
                label = child.getRoom().getRoditelj().getNaziv() + "\\";
            }
            else{
                label = child.getRoom().getRoditelj().getRoditelj().getNaziv() + "\\" + child.getRoom().getRoditelj().getNaziv();
            }
            child.add(new JLabel(label));
            addTab(child.getRoom().getNaziv(), child);
        }
        for(int i=0; i<getTabCount(); i++){
            setBackgroundAt(i,((TabPanel)getComponentAt(i)).getRoom().getColor());
            setForegroundAt(i, ColorUtils.getContrastingTextColor(((TabPanel) getComponentAt(i)).getRoom().getColor()));
        }
    }


}
