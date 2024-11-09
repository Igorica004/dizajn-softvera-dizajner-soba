package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tabbedpane.ColorUtils;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

@Data
public class TabbedPaneView extends JTabbedPane {
    public TabbedPaneView() {
        super(JTabbedPane.TOP, JTabbedPane.SCROLL_TAB_LAYOUT);
        setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
    }
    public void initialize(ArrayList<DraftNode> tabovi){
        removeAll();
        for(DraftNode child : tabovi)
            addTab(child.getIme(),child);
        for(int i=0; i<getTabCount(); i++){
            setBackgroundAt(i,((DraftNode)getComponentAt(i)).getColor());
            setForegroundAt(i, ColorUtils.getContrastingTextColor(((DraftNode) getComponentAt(i)).getColor()));
        }
    }


}
