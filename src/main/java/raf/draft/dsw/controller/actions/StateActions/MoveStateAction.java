package raf.draft.dsw.controller.actions.StateActions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class MoveStateAction extends AbstractRoomAction {
    public MoveStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/move.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstanca().getDesniPanel().startMoveState();
    }
}
