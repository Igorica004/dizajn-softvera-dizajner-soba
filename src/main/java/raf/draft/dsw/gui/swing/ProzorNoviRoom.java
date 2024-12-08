package raf.draft.dsw.gui.swing;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tree.model.DraftTreeItem;
import raf.draft.dsw.utils.DraftNodeUtils;
import raf.draft.dsw.utils.JPanelUtils;

import javax.swing.*;
import java.awt.*;
import java.time.LocalDateTime;

public class ProzorNoviRoom extends JDialog{
    public ProzorNoviRoom(String editOrMake){initialize(editOrMake);}

    JTextField tfNaziv = new JTextField(20);
    JTextField tfDimenzijaX = new JTextField(20);
    JTextField tfDimenzijaY = new JTextField(20);
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
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        panel.add(JPanelUtils.makeVBox(
                JPanelUtils.makeHBox(
                        new JLabel("Naziv: "),
                        tfNaziv
                ),
                JPanelUtils.makeHBox(
                        new JLabel("Sirina: "),
                        tfDimenzijaX
                ),
                JPanelUtils.makeHBox(
                        new JLabel("Visina:"),
                        tfDimenzijaY
                ),
                button

        ));
        pack();

    }
    public Room getRoom() {
        DraftTreeItem selected = MainFrame.getInstanca().getDraftTree().getSelectedNode();
        Dimension dimenzija = new Dimension();
        dimenzija.width = Integer.parseInt(tfDimenzijaX.getText());
        dimenzija.height = Integer.parseInt(tfDimenzijaY.getText());
        if(tfNaziv.getText().isEmpty()) return new Room("Room" + selected.getChildCount(),null, dimenzija);
        return new Room(tfNaziv.getText(),null, dimenzija);
    }
    public void setRoom()
    {
        DraftNode cvor = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        String naziv = tfNaziv.getText();
        DraftNode dn = new Room(naziv,cvor.getRoditelj());
        if(!DraftNodeUtils.nameIsValid(dn)){
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"Greska pri imenovanju!");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }
        cvor.setNaziv(naziv);
    }
}
