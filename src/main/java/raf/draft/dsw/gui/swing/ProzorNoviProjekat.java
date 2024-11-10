package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.*;

public class ProzorNoviProjekat extends JDialog {
    private JButton dugmeNoviProzor;
    private boolean ucitano = false;
    public ProzorNoviProjekat(String editOrMake){initialize(editOrMake);}

    private JTextField fieldAutor,fieldNaziv,fieldPutanja;

    public void initialize(String editOrMake){
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
        if(editOrMake.equals("Make")){
            dugmeNoviProzor = new JButton("Napravi projekat");
        }
        else dugmeNoviProzor = new JButton("Izmeni");
        dugmeNoviProzor.addActionListener(e->{dispose();});
        panel1.add(panel2);
        panel1.add(dugmeNoviProzor);
        setContentPane(panel1);
        pack();
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public Project getProject()
    {
        DraftTreeItem selected = MainFrame.getInstanca().getDraftTree().getSelectedNode();
        if(fieldNaziv.getText().isEmpty()) return new Project(fieldAutor.getText(),null,"Project" + selected.getChildCount(),fieldNaziv.getText());
        return new Project(fieldAutor.getText(),null,fieldNaziv.getText(),fieldPutanja.getText());
    }
    public void setProject()
    {
        ((Project)MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode()).setAutor(fieldAutor.getText());
        MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode().setNaziv(fieldNaziv.getText());
        ((Project)MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode()).setPutanja(fieldPutanja.getText());
    }
}
