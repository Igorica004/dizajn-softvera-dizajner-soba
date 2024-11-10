package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ProzorNoviBuildingRoom extends JDialog {
    public ProzorNoviBuildingRoom(String editOrMake) {
        initialize(editOrMake);
    }

    JTextField tfNaziv = new JTextField(20);
    JButton button;
    JRadioButton radioButton1 = new JRadioButton("Building");
    JRadioButton radioButton2 = new JRadioButton("Room");
    ButtonGroup group = new ButtonGroup();

    private void initialize(String editOrMake) {
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


        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.add(new JLabel("Naziv: "));
        panel.add(tfNaziv);

        JPanel panel1 = new JPanel();
        panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));

        if (editOrMake.equals("Make")) {
            button = new JButton("Napravi");
            panel.add(new JLabel("Tip:"));
            panel1.add(radioButton1);
            panel1.add(radioButton2);
        }
        else button = new JButton("Izmeni");
        button.addActionListener(e->{dispose();});
        panel.add(panel1);
        panel.add(button);
        pack();

    }
    public DraftNode getDraftNode() {
        DraftNode draftNode = null;
        DraftTreeItem selectedNode = MainFrame.getInstanca().getDraftTree().getSelectedNode();
        if(radioButton1.isSelected()) {
            if (tfNaziv.getText().isEmpty()) draftNode = new Building("Building" + selectedNode.getChildCount(), null);
            else draftNode = new Building(tfNaziv.getText(), null);
        }
        else
            if(tfNaziv.getText().isEmpty()) draftNode = new Room("Room" + selectedNode.getChildCount(), null);
            else draftNode = new Room(tfNaziv.getText(),null);
        return draftNode;
    }

    public void setBuilding()
    {
        MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode().setNaziv(tfNaziv.getText());
    }
}
