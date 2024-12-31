package raf.draft.dsw.serializer.actions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.serializer.Serializer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class OpenProjectAkcija extends AbstractRoomAction {
    public OpenProjectAkcija() {
        putValue(SMALL_ICON, loadIcon("/images/open.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Serializer.getInstanca().deserialize(chooser.getSelectedFile());
        }
    }
}
