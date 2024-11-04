package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.model.messages.Message;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class ProzorGreska extends JFrame {
    public ProzorGreska(Notification notification){
        inicijalizuj(notification.getPoruka());
    }

    private void inicijalizuj(Message poruka){
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 4, screenHeight / 4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Greska!");

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.Y_AXIS));
        JLabel labelPoruka = new JLabel(poruka.toString());
        panel1.add(labelPoruka);
        Border padding = BorderFactory.createEmptyBorder(10, 10, 10, 10);
        panel1.setBorder(padding);
        setContentPane(panel1);

        pack();
    }
}
