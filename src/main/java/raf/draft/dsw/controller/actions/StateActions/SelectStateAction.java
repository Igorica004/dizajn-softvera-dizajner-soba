package raf.draft.dsw.controller.actions.StateActions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.gui.swing.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SelectStateAction extends AbstractRoomAction {
    public SelectStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/select.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        //System.out.println(MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState().getClass().getSimpleName());
        MainFrame.getInstanca().getDesniPanel().startSelectState();
    }
}
