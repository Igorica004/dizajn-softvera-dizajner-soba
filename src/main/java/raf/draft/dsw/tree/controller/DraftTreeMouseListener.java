package raf.draft.dsw.tree.controller;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.structures.Project;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DraftTreeMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode() instanceof Project)
            MainFrame.getInstanca().getTabbedPane().updateTabbedPane();
    }
}
