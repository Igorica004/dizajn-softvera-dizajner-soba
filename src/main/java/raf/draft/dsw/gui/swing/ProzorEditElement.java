package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.painters.DevicePainter;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.roomobjects.RoomDevice;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;
import raf.draft.dsw.utils.JPanelUtils;

import javax.swing.*;
import java.awt.*;

public class ProzorEditElement extends JDialog {
    public JTextField tfDimenzijaX = new JTextField();
    public JTextField tfDimenzijaY = new JTextField();
    public JTextField tfNaziv = new JTextField();
    public JTextField tfRotacija = new JTextField();

    private JLabel labelDimenzijaX = new JLabel("Sirina: ");
    private JLabel labelDimenzijaY = new JLabel("Visina: ");
    private JLabel labelNaziv = new JLabel("Naziv: ");
    private JLabel labelRotacija = new JLabel("Rotacija: ");

    private JButton button = new JButton("Izmeni");
    public ProzorEditElement(ElementPainter ep) {initialize(ep);}

    private void initialize(ElementPainter ep)
    {
        button.addActionListener(a->{dispose();});
        setModal(true);
        setLocationRelativeTo(null);
        JPanel panel = new JPanel();
        setContentPane(panel);
        panel.setLayout(new BoxLayout(panel,BoxLayout.X_AXIS));
        tfNaziv.setText(ep.getRoomElement().getNaziv());
        tfDimenzijaX.setText(String.valueOf(((RoomDevice)ep.getRoomElement()).getLokacija().x));
        tfDimenzijaY.setText(String.valueOf(((RoomDevice)ep.getRoomElement()).getLokacija().y));
        tfRotacija.setText(String.valueOf(ep.getRoomElement().getRotateRatio()));
        add(JPanelUtils.makeHBox(
                JPanelUtils.makeVBox(
                        labelNaziv,
                        labelDimenzijaX,
                        labelDimenzijaY,
                        labelRotacija
                ),
                JPanelUtils.makeVBox(
                        tfNaziv,
                        tfDimenzijaX,
                        tfDimenzijaY,
                        tfRotacija
                ),
                button
        ));
        pack();
    }
    public void setElement(ElementPainter ep)
    {
        Dimension d = new Dimension(Integer.parseInt(tfDimenzijaX.getText()), Integer.parseInt(tfDimenzijaY.getText()));
        ((DevicePainter)ep).setDimenzija(d);
        ((RoomDevice)ep.getRoomElement()).setDimenzija(d);
        ep.getRoomElement().setRotateRatio(Double.parseDouble(tfRotacija.getText()));
        ep.setRoomElement(ep.getRoomElement());
    }
}
