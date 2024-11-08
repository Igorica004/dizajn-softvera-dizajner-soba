package raf.draft.dsw.gui.swing;

import lombok.Data;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tree.model.DraftTreeItem;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import java.awt.*;
import java.util.ArrayList;

@Data
public class TabbedPane implements TreeSelectionListener {

    @Override
    public void valueChanged(TreeSelectionEvent e) {
        //veza izmedju sobe i prikaza treba da se cuva negde drugde
        
        DraftTreeItem treeItemSelected = MainFrame.getInstanca().getDraftTree().getSelectedNode();
        if((treeItemSelected.getDraftNode() instanceof Project)) {
            MainFrame.getInstanca().getTabbedPane().removeAll();
            ArrayList<DraftNode> lista = ((Project) treeItemSelected.getDraftNode()).getChildren();
            for (DraftNode n : lista) {
                if(n instanceof Room) {
                    MainFrame.getInstanca().getTabbedPane().addTab("Soba", new JLabel("\\"));
                }
                else {
                    for(DraftNode d : ((Building) n).getChildren()) {
                        MainFrame.getInstanca().getTabbedPane().addTab("Soba", new JLabel(n.getIme()));
                    }
                }
            }
        }
    }
}
