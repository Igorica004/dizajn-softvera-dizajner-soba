package raf.draft.dsw.gui.swing;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.painters.*;
import raf.draft.dsw.model.roomobjects.*;
import raf.draft.dsw.tabbedpane.view.RoomView;
import raf.draft.dsw.utils.JPanelUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class OrganizeMyRoomProzor extends JDialog {
    private ArrayList<ElementPainter> elementiZaDodavanje = new ArrayList<>();
    private ArrayList<JButton> buttons = new ArrayList<>();

    private JLabel labelSirina = new JLabel("Sirina: ");
    private JLabel labelVisina = new JLabel("Visina: ");
    private JTextField tfSirina = new JTextField(10);
    private JTextField tfVisina = new JTextField(10);

    private JComboBox<String> moguciElementi = new JComboBox<>();
    private JButton button = new JButton("Organizuj");
    private JPanel spisak = new JPanel();
    public OrganizeMyRoomProzor() {initialize();}

    private void initialize() {
        setSize(450, 200);
        setModal(true);
        setLocationRelativeTo(null);

        moguciElementi.addItem("bojler");
        moguciElementi.addItem("kada");
        moguciElementi.addItem("krevet");
        moguciElementi.addItem("lavabo");
        moguciElementi.addItem("ormar");
        moguciElementi.addItem("sto");
        moguciElementi.addItem("ves masina");
        moguciElementi.addItem("vrata");
        moguciElementi.addItem("wc solja");
        moguciElementi.setSelectedIndex(0);
        moguciElementi.addActionListener(e->{dodajElement(moguciElementi.getSelectedItem().toString());});
        button.addActionListener(e->{dispose();});

        spisak.setLayout(new BoxLayout(spisak,BoxLayout.Y_AXIS));
        JPanel panel = new JPanel();
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(2,3));
        panel1.add(labelSirina);
        panel1.add(tfSirina);
        panel1.add(moguciElementi);
        panel1.add(labelVisina);
        panel1.add(tfVisina);
        panel.add(panel1);
        panel.add(spisak);
        panel.add(button);
        JScrollPane sp = new JScrollPane(panel);
        setContentPane(sp);

    }
    void dodajElement(String element)
    {
        if(tfSirina.getText().isEmpty() || tfVisina.getText().isEmpty()){
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"pogresno uneta dimenzija");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }
        RoomElement k;
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        Dimension d = new Dimension();
        d.width = Integer.parseInt(tfSirina.getText());
        d.width*= rv.getScale();
        d.height = Integer.parseInt(tfVisina.getText());
        d.height*= rv.getScale();
        switch(element)
        {
            case "bojler":
                k = new Bojler("bojler", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new BojlerPainter(k, new Point(1,1), d));
                break;
            case "kada":
                k = new Kada("kada", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new KadaPainter(k, new Point(1,1), d));
                break;
            case "lavabo":
                k = new Lavabo("lavabo", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new LavaboPainter(k, new Point(1,1), d));
                break;
            case "vrata":
                k = new Vrata("vrata", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new VrataPainter(k, new Point(1,1), d));
                break;
            case "wc solja":
                k = new WCSolja("wc solja", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new WCSoljaPainter(k, new Point(1,1), d));
                break;
            case "ves masina":
            case "sto":
            case "ormar":
            case "krevet":
                k = new Krevet("krevet", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new KrevetPainter(k, new Point(1,1), d));
                break;
            default:
                Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"pogresno (nekako) selektovan element");
                ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
        }
        JButton button = new JButton("x");
        buttons.add(button);
        button.addActionListener(e->{obrisiElement(buttons.indexOf(button));});
        spisak.add(JPanelUtils.makeHBox(new JLabel(element + "(" + tfSirina.getText() + " x " + tfVisina.getText() + ")"), button));
        revalidate();
    }
    public void obrisiElement(int a)
    {
        spisak.remove(a);
        elementiZaDodavanje.remove(a);
        buttons.remove(a);
        revalidate();
    }
    public ArrayList<ElementPainter> getSpisakElemenata()
    {
        return elementiZaDodavanje;
    }
}
