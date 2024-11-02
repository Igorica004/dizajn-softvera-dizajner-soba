package raf.draft.dsw.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;

public class ProzorONama extends JFrame {
    public ProzorONama() {
        inicijalizuj();
    }

    private void inicijalizuj() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height + 20;
        int screenWidth = 200;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("O Nama");

        JTextPane anastasija = new JTextPane();
        anastasija.setEditable(false);
        anastasija.setText("Anastasija Lazic RN 39/2023");
        ImageIcon imageIconAnastasija = new ImageIcon(getClass().getResource("/images/anastasija.png"));
        Image smanjenaSlikaAnastasija = imageIconAnastasija.getImage().getScaledInstance(300,200,Image.SCALE_DEFAULT);
        JLabel slikaAnastasija = new JLabel(new ImageIcon(smanjenaSlikaAnastasija));

        JTextPane igor = new JTextPane();
        igor.setText("Igor Damjanovic RN 24/2023");
        igor.setEditable(false);
        ImageIcon imageIconIgor = new ImageIcon(getClass().getResource("/images/igor.png"));
        JLabel slikaIgor = new JLabel(imageIconIgor);

        JPanel j1 = new JPanel();
        j1.setLayout(new BorderLayout());
        j1.add(anastasija, BorderLayout.NORTH);
        j1.add(igor, BorderLayout.SOUTH);
        JPanel j2 = new JPanel();
        j2.setLayout(new BoxLayout(j2,BoxLayout.Y_AXIS));
        j2.add(slikaAnastasija,BorderLayout.NORTH);
        j2.add(slikaIgor,BorderLayout.SOUTH);
        j1.add(j2);
        //add(j1, BorderLayout.CENTER);
        setContentPane(j1);
        pack();
    }
}
