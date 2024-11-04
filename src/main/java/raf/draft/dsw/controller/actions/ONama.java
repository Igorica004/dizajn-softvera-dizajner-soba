package raf.draft.dsw.controller.actions;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.ProzorONama;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;
import java.time.LocalDateTime;

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
        //ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.OBAVESTENJE, LocalDateTime.now(), "tEsT"));
    }
}
