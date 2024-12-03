package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.StateActions.*;

import javax.swing.*;

public class StateToolBar extends JToolBar {

    public StateToolBar() {
        super(VERTICAL);
        setFloatable(false);

        AddStateAction addStateAction = MainFrame.getInstanca().getActionManager().getAddStateAction();
        EditRoomStateAction editRoomStateAction = MainFrame.getInstanca().getActionManager().getEditRoomStateAction();
        MoveStateAction moveStateAction = MainFrame.getInstanca().getActionManager().getMoveStateAction();
        ResizeStateAction resizeStateAction = MainFrame.getInstanca().getActionManager().getResizeStateAction();
        SelectStateAction selectStateAction = MainFrame.getInstanca().getActionManager().getSelectStateAction();

        add(addStateAction);
        add(editRoomStateAction);
        add(moveStateAction);
        add(resizeStateAction);
        add(selectStateAction);
    }
}
