package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.tabbedpane.view.RoomView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class RedoAction extends AbstractRoomAction{
    public RedoAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/redo.png"));
        putValue(NAME, "Redo");
        putValue(SHORT_DESCRIPTION, "Redo");
        setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        rv.getCommandManager().doCommand();
    }
}
