package raf.draft.dsw.gui.swing;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.utils.JPanelUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;

public class NoviObjekatProzor extends JDialog {
    JTextField tfDimenzijaX = new JTextField(10);
    JTextField tfDimenzijaY = new JTextField(10);
    JButton button = new JButton("Dodaj");
    JRadioButton radioButton1 = new JRadioButton("Bojler");
    JRadioButton radioButton2 = new JRadioButton("Kada");
    JRadioButton radioButton3 = new JRadioButton("Krevet");
    JRadioButton radioButton4 = new JRadioButton("Lavabo");
    JRadioButton radioButton5 = new JRadioButton("Ormar");
    JRadioButton radioButton6 = new JRadioButton("Sto");
    JRadioButton radioButton7 = new JRadioButton("Ves masina");
    JRadioButton radioButton8 = new JRadioButton("Vrata");
    JRadioButton radioButton9 = new JRadioButton("WC solja");
    ButtonGroup group = new ButtonGroup();
    public NoviObjekatProzor() {initialize();}
    public void initialize() {
        group.add(radioButton1);
        group.add(radioButton2);
        group.add(radioButton3);
        group.add(radioButton4);
        group.add(radioButton5);
        group.add(radioButton6);
        group.add(radioButton7);
        group.add(radioButton8);
        group.add(radioButton9);
        setModal(true);
        setLocationRelativeTo(null);
        button.addActionListener(e->{dispose();});

        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
        add(JPanelUtils.makeVBox(
                JPanelUtils.makeHBox(
                        new JLabel("Sirina:"),
                        tfDimenzijaX
                ),
                JPanelUtils.makeHBox(
                        new JLabel("Visina:"),
                        tfDimenzijaY
                ),
                button
        ));
        add(JPanelUtils.makeVBox(
                radioButton1, radioButton2,
                radioButton3, radioButton4,
                radioButton5, radioButton6,
                radioButton7, radioButton8, radioButton9
        ));
        add(button);
        pack();
    }
    public String getOdabrani() {
        for (java.util.Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements(); ) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                return button.getText();
            }
        }
        return null;
    }
    public Dimension getDimension(){
        int x,y;
        try{
            x = Integer.parseInt(tfDimenzijaX.getText());
            y = Integer.parseInt(tfDimenzijaY.getText());
            return new Dimension(x,y);
        }
        catch(Exception e){
            return null;
        }
    }
}
