package raf.draft.dsw.gui.swing;

import lombok.Data;
import raf.draft.dsw.utils.JPanelUtils;

import javax.swing.*;

@Data
public class ProzorDimenzijeSobe extends JDialog {
    JTextField tfDimenzijaX = new JTextField();
    JTextField tfDimenzijaY = new JTextField();
    public ProzorDimenzijeSobe(){initialize();}


    JButton btn = new JButton("Napravi sobu");
    private void initialize(){
        btn.addActionListener(a->{dispose();});
        setModal(true);
        setLocationRelativeTo(null);
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
                btn
        ));
        pack();
    }
}
