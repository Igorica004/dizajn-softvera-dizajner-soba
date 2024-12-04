package raf.draft.dsw.controller.actions.StateActions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class ResizeStateAction extends AbstractRoomAction {
    public ResizeStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/resize.png"));
        putValue(NAME, "Resize");
        putValue(SHORT_DESCRIPTION, "Resize");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstanca().getDesniPanel().startResizeState();
    }
}
