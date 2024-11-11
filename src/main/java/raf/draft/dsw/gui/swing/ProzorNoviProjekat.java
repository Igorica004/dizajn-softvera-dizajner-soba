package raf.draft.dsw.gui.swing;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tree.model.DraftTreeItem;
import raf.draft.dsw.utils.DraftNodeUtils;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

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
        if(fieldNaziv.getText().isEmpty()) return new Project(fieldAutor.getText(), "Project" + selected.getChildCount(), fieldNaziv.getText(), null);
        return new Project(fieldAutor.getText(), fieldNaziv.getText(), fieldPutanja.getText(), null);
    }
    public void setProject()
    {
        //((Project)MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode()).setAutor(fieldAutor.getText());
        //MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode().setNaziv(fieldNaziv.getText());
        //((Project)MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode()).setPutanja(fieldPutanja.getText());


        DraftNode cvor = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        String naziv = fieldNaziv.getText(), autor = fieldAutor.getText(), putanja = fieldPutanja.getText();
        DraftNode dn = new Project(autor,naziv,putanja,cvor.getRoditelj());
        if(!DraftNodeUtils.nameIsValid(dn)){
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"Greska pri imenovanju!");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }
        Project project = (Project) cvor;
        project.setNaziv(naziv);
        project.setAutor(autor);
        project.setPutanja(putanja);
    }
}
