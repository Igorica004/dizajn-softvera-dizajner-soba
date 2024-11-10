package raf.draft.dsw.tree.controller;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.tree.model.DraftTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class DraftTreeSelectionListener implements TreeSelectionListener {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        //DraftTreeItem treeItemSelected = (DraftTreeItem) path.getLastPathComponent();
        DraftTreeItem treeItemSelected = MainFrame.getInstanca().getDraftTree().getSelectedNode();
        System.out.println("Selektovan cvor:"+ treeItemSelected.getDraftNode().getNaziv());
        System.out.println("getPath: "+e.getPath());

    }
}
