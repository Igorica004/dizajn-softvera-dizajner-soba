package raf.draft.dsw.serializer.actions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.serializer.Serializer;

import java.awt.event.ActionEvent;

public class LoadPatternAkcija extends AbstractRoomAction {
    public LoadPatternAkcija() {
        putValue(SMALL_ICON, loadIcon("/images/open.png"));
        putValue(NAME, "Load pattern");
        putValue(SHORT_DESCRIPTION, "Load pattern");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Serializer.getInstanca().loadPattern();
    }
}
