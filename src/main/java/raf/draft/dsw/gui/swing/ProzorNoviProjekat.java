package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.structures.Project;

import javax.swing.*;
import java.awt.*;

public class ProzorNoviProjekat extends JDialog {
    private JButton dugmeNoviProzor = new JButton("Napravi projekat");
    private boolean ucitano = false;
    public ProzorNoviProjekat(){initialize();}

    private JTextField fieldAutor,fieldNaziv,fieldPutanja;

    public void initialize(){
        this.setModal(true);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
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
        dugmeNoviProzor.addActionListener(e->{dispose();});
        panel1.add(panel2);
        panel1.add(dugmeNoviProzor);
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public Project getProject()
    {
        return new Project(fieldAutor.getText(),null,fieldNaziv.getText(),fieldPutanja.getText());
    }

}
