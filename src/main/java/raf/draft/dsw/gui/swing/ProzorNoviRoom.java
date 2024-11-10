package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.*;

public class ProzorNoviRoom extends JDialog{
    public ProzorNoviRoom(String editOrMake){initialize(editOrMake);}

    JTextField tfNaziv = new JTextField(20);
    JButton button;

    private void initialize(String editOrMake) {
        this.setModal(true);
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        if(editOrMake.equals("Make")){
            button = new JButton("Napravi");
        }
        else button = new JButton("Izmeni");
        button.addActionListener(e->{dispose();});

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.add(new JLabel("Naziv: "));
        panel.add(tfNaziv);
        panel.add(button);
        pack();

    }
    public Room getRoom() {
        DraftTreeItem selected = MainFrame.getInstanca().getDraftTree().getSelectedNode();
        if(tfNaziv.getText().isEmpty()) return new Room("Room" + selected.getChildCount(),null);
        return new Room(tfNaziv.getText(),null);
    }
    public void setRoom()
    {

        MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode().setNaziv(tfNaziv.getText());
    }
}
