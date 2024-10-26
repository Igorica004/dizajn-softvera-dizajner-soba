package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ProzorONama;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class ONama extends AbstractRoomAction {
    public ONama() {
        //bitno
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/onama.png"));
        putValue(NAME, "O nama");
        putValue(SHORT_DESCRIPTION, "O nama");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProzorONama prozorONama = new ProzorONama();
        prozorONama.setVisible(true);
    }
}
