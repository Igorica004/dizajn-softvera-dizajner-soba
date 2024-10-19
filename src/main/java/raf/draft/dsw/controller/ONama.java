package raf.draft.dsw.controller;

import raf.draft.dsw.gui.swing.ProzorONama;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class ONama extends AbstractAction {
    public ONama() {
        //bitno
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/onama.png"));
        putValue(NAME, "O nama");
        putValue(SHORT_DESCRIPTION, "O nama");
    }

    //deo koda za ucitavanje ikonice...
    private Icon loadIcon(String path) {
        Icon icon = null;
        URL ImageURL = getClass().getResource(path);
        if (ImageURL != null) {
            Image img = new ImageIcon(ImageURL).getImage();
            Image newImg = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            icon = new ImageIcon(newImg);
        } else {
            System.err.println("File " + "images/onama.png" + " not found");
        }
        return icon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ProzorONama prozorONama = new ProzorONama();
        prozorONama.setVisible(true);
    }
}
