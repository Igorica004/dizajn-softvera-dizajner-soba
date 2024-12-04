package raf.draft.dsw.controller.actions.StateActions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class EditRoomStateAction extends AbstractRoomAction {
    public EditRoomStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/edit.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstanca().getDesniPanel().startEditRoomState();
    }
}
