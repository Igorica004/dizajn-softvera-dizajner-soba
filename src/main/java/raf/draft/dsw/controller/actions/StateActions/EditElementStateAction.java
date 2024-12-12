package raf.draft.dsw.controller.actions.StateActions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.gui.swing.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class EditElementStateAction extends AbstractRoomAction {
    public EditElementStateAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit selected Object");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstanca().getDesniPanel().startEditElementState();
    }
}
