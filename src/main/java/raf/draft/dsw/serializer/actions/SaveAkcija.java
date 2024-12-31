package raf.draft.dsw.serializer.actions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.serializer.Serializer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveAkcija extends AbstractRoomAction {
    public SaveAkcija() {
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save");
        putValue(SHORT_DESCRIPTION, "Save");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Serializer.getInstanca().serialize(null);
    }
}
