package raf.draft.dsw.tree.view;

import raf.draft.dsw.tree.controller.DraftTreeCellEditor;
import raf.draft.dsw.tree.controller.DraftTreeSelectionListener;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;

public class DraftTreeView extends JTree {
    public DraftTreeView(DefaultTreeModel defaultTreeModel) {
        setModel(defaultTreeModel);
        DraftTreeCellRender draftTreeCellRender = new DraftTreeCellRender();
        addTreeSelectionListener(new DraftTreeSelectionListener());
        setCellEditor(new DraftTreeCellEditor(this,draftTreeCellRender));
        setCellRenderer(draftTreeCellRender);
        setEditable(true);
    }
}
