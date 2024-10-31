package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.model.messages.Message;

import javax.swing.*;
import java.awt.*;

public class ProzorGreska extends JFrame {
    public ProzorGreska(Notification notification){
        inicijalizuj(notification.getPoruka());
    }
    private void inicijalizuj(Message poruka){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height + 20;
        int screenWidth = 200;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Greska!");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        JLabel labelPoruka = new JLabel(poruka.toString());
        panel1.add(labelPoruka);
        add(panel1,CENTER_ALIGNMENT);
    }
}
