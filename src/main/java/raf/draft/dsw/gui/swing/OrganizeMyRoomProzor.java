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
import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;

public class OrganizeMyRoomProzor extends JDialog {
    private ArrayList<ElementPainter> elementiZaDodavanje = new ArrayList<>();
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
        setContentPane(panel);

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
        switch(element)
        {
            case "bojler":
                k = new Bojler("bojler", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new BojlerPainter(k, new Point(1,1), new Dimension(Integer.parseInt(tfSirina.getText()),Integer.parseInt(tfVisina.getText()))));
                break;
            case "kada":
                k = new Kada("bojler", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new KadaPainter(k, new Point(1,1), new Dimension((int)(Integer.parseInt(tfSirina.getText())*rv.getScale()), (int)(Integer.parseInt(tfVisina.getText())* rv.getScale()))));                break;
            case "lavabo":
                k = new Lavabo("bojler", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new LavaboPainter(k, new Point(1,1), new Dimension((int)(Integer.parseInt(tfSirina.getText())*rv.getScale()), (int)(Integer.parseInt(tfVisina.getText())* rv.getScale()))));
                break;
            case "vrata":
                k = new Vrata("bojler", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new VrataPainter(k, new Point(1,1), new Dimension((int)(Integer.parseInt(tfSirina.getText())*rv.getScale()), (int)(Integer.parseInt(tfVisina.getText())* rv.getScale()))));
                break;
            case "wc solja":
                k = new WCSolja("bojler", null, Color.red, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new WCSoljaPainter(k, new Point(1,1), new Dimension((int)(Integer.parseInt(tfSirina.getText())*rv.getScale()), (int)(Integer.parseInt(tfVisina.getText())* rv.getScale()))));
                break;
            case "ves masina":
            case "sto":
            case "ormar":
            case "krevet":
                k = new Krevet("bojler", null, Color.BLACK, 0,new BasicStroke(BasicStroke.CAP_BUTT));
                elementiZaDodavanje.add(new KrevetPainter(k, new Point(1,1), new Dimension((int)(Integer.parseInt(tfSirina.getText())*rv.getScale()), (int)(Integer.parseInt(tfVisina.getText())* rv.getScale()))));
                break;
            default:
                Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"pogresno (nekako) selektovan element");
                ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
        }
        JButton button = new JButton("x");
        button.addActionListener(e->{obrisiElement();});
        spisak.add(JPanelUtils.makeHBox(new JLabel(element + "(" + tfSirina.getText() + " x " + tfVisina.getText() + ")"), button));
        revalidate();
        System.out.println("dodat element");
    }
    public void obrisiElement()
    {
        spisak.remove(0);
        elementiZaDodavanje.removeFirst();
        revalidate();
    }
    public ArrayList<ElementPainter> getSpisakElemenata()
    {
        return elementiZaDodavanje;
    }
}
