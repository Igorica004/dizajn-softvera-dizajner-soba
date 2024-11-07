package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProzorNoviBuildingRoom extends JDialog {
    public ProzorNoviBuildingRoom() {initialize();}

    JTextField tfNaziv = new JTextField(20);
    JButton button = new JButton("Napravi");
    JRadioButton radioButton1 = new JRadioButton("Building");
    JRadioButton radioButton2 = new JRadioButton("Room");
    ButtonGroup group = new ButtonGroup();

    private void initialize() {
        group.add(radioButton1);
        group.add(radioButton2);

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
        panel.add(new JLabel("Tip:"));
        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
        panel1.add(radioButton1);
        panel1.add(radioButton2);
        panel.add(panel1);
        panel.add(button);
        pack();

    }
    public DraftNode getDraftNode() {
        DraftNode draftNode = null;
        if(radioButton1.isSelected())
            draftNode = new Building(tfNaziv.getText(),null);
        else
            draftNode = new Room(tfNaziv.getText(),null);
        return draftNode;
    }
}
