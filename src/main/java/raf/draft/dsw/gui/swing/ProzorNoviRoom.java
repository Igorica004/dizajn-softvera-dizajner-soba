package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;

public class ProzorNoviRoom extends JDialog{
    public ProzorNoviRoom(){initialize();}

    JTextField tfNaziv = new JTextField(20);
    JButton button = new JButton("Napravi sobu");

    private void initialize() {
        this.setModal(true);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        button.addActionListener(e->{dispose();});

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.add(new JLabel("Naziv: "));
        panel.add(tfNaziv);
        panel.add(button);
        pack();

    }
    public Room getRoom() {
        return new Room(tfNaziv.getText(),null);
    }
}
