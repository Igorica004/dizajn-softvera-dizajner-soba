package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.NoviProjekatAkcija;

import javax.swing.*;
import java.awt.*;

public class ProzorNoviProjekatForma extends JFrame {
    private JButton dugmeNoviProzor = new JButton("Napravi projekat");
    public ProzorNoviProjekatForma()
    {
        inicijalizuj();
    }
    public void inicijalizuj()
    {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height + 20;
        int screenWidth = 200;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Novi projekat");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();

        JLabel labelAutor = new JLabel("Autor: ");
        JLabel labelNaziv = new JLabel("Naziv: ");
        JLabel labelPutanja = new JLabel("Putanja: ");
        JTextField fieldAutor = new JTextField(10);
        JTextField fieldNaziv = new JTextField(10);
        JTextField fieldPutanja = new JTextField(10);

        panel2.setLayout(new GridLayout(3,2));
        panel2.add(labelAutor);
        panel2.add(fieldAutor);
        panel2.add(labelNaziv);
        panel2.add(fieldNaziv);
        panel2.add(labelPutanja);
        panel2.add(fieldPutanja);
        dugmeNoviProzor.addActionListener(new NoviProjekatAkcija(fieldAutor.getText(), fieldNaziv.getText(), fieldPutanja.getText(), this));
        panel1.add(panel2);
        panel1.add(dugmeNoviProzor);
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }

}
