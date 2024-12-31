package raf.draft.dsw.controller.actions.StateActions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomStateAction extends AbstractRoomAction {
    public ZoomStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/resize.png"));
        putValue(NAME, "Zoom");
        putValue(SHORT_DESCRIPTION, "Zoom");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstanca().getDesniPanel().startZoomState();
    }
}
