package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.NoviProjekatAkcija;
import raf.draft.dsw.model.structures.Project;

import javax.swing.*;
import java.awt.*;

public class ProzorNoviProjekatForma extends JDialog {
    private JButton dugmeNoviProzor = new JButton("Napravi projekat");
    private boolean ucitano = false;
    public ProzorNoviProjekatForma(){initialize();}

    private JTextField fieldAutor,fieldNaziv,fieldPutanja;
    private String autor,naziv,putanja;

    public void initialize(){
        this.setModal(true);
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
        fieldAutor = new JTextField(10);
        fieldNaziv = new JTextField(10);
        fieldPutanja = new JTextField(10);

        panel2.setLayout(new GridLayout(3,2));
        panel2.add(labelAutor);
        panel2.add(fieldAutor);
        panel2.add(labelNaziv);
        panel2.add(fieldNaziv);
        panel2.add(labelPutanja);
        panel2.add(fieldPutanja);
        dugmeNoviProzor.addActionListener(e->{autor = fieldAutor.getText();naziv = fieldNaziv.getText();putanja = fieldPutanja.getText();dispose();});
        panel1.add(panel2);
        panel1.add(dugmeNoviProzor);
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public Project getProject()
    {
        return new Project(autor,null,naziv,putanja);
    }

}
