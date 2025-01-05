package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.OrganizeMyRoomProzor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class OrganizeMyRoomAction extends AbstractRoomAction{
    OrganizeMyRoomAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/organize.png"));
        putValue(NAME, "Organize");
        putValue(SHORT_DESCRIPTION, "Organize My Room");
        setEnabled(false);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstanca().getDesniPanel().getSelectedTab().organize();

    }
}
