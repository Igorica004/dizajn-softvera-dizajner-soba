package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class PasteElementaAkcija extends AbstractRoomAction{
    public PasteElementaAkcija() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/clipboard-icon.png"));
        putValue(NAME, "Paste");
        putValue(SHORT_DESCRIPTION, "Paste");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        rv.repaint();
    }
}
