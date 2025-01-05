package raf.draft.dsw.serializer.actions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.serializer.Serializer;

import java.awt.event.ActionEvent;

public class SavePatternAkcija extends AbstractRoomAction {
    public SavePatternAkcija() {
        putValue(SMALL_ICON, loadIcon("/images/save.png"));
        putValue(NAME, "Save pattern");
        putValue(SHORT_DESCRIPTION, "Save pattern");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Serializer.getInstanca().savePattern();
    }
}
