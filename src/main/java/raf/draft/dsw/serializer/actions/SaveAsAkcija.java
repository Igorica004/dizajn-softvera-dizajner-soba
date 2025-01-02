package raf.draft.dsw.serializer.actions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.serializer.Serializer;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class SaveAsAkcija extends AbstractRoomAction {
    public SaveAsAkcija() {
        putValue(SMALL_ICON, loadIcon("/images/save-as.png"));
        putValue(NAME, "Save as...");
        putValue(SHORT_DESCRIPTION, "Save as...");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser chooser = new JFileChooser();
        if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            Serializer.getInstanca().serialize(chooser.getSelectedFile().getAbsolutePath());
        }
    }
}
