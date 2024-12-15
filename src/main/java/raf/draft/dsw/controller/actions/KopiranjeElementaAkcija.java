package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class KopiranjeElementaAkcija extends AbstractRoomAction{
    public KopiranjeElementaAkcija() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/copied-icon.png"));
        putValue(NAME, "Copy");
        putValue(SHORT_DESCRIPTION, "Copy");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        rv.getKopirani().clear();
        rv.getKopirani().addAll(rv.getSelektovani());
        System.out.println("Elementi kopirani");
    }
}
