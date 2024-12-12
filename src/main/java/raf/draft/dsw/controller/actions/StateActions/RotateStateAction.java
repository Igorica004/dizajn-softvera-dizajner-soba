package raf.draft.dsw.controller.actions.StateActions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class RotateStateAction extends AbstractRoomAction {
    public RotateStateAction() {
        putValue(SMALL_ICON, loadIcon("/images/rotation.png"));
        putValue(NAME, "Rotate");
        putValue(SHORT_DESCRIPTION, "Rotate");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstanca().getDesniPanel().startRotateState();
    }
}

