package raf.draft.dsw.state.concrete;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.painters.*;
import raf.draft.dsw.model.roomobjects.*;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.tree.model.DraftTreeItem;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.time.LocalDateTime;

public class AddState implements State {

    @Override
    public void misPrevucen(MouseEvent e) {

    }

    @Override
    public void misOtpusten(MouseEvent e) {

    }

    @Override
    public void misSkrol(MouseWheelEvent e) {

    }

    @Override
    public void misKliknut(MouseEvent e) {

    }

    @Override
    public void misPritisnut(MouseEvent e) {

        String s = MainFrame.getInstanca().getDesniPanel().getElementToAdd();
        Dimension d = new Dimension(MainFrame.getInstanca().getDesniPanel().getDimensionToAdd());
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        d.width*=rv.getScale();
        d.height*=rv.getScale();
        RoomElement k;
        ElementPainter p;
        DraftTreeItem room = new DraftTreeItem(rv.getRoom());
        switch (s) {
            case "Bojler":
                k = new Bojler("bojler"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new BojlerPainter(k,e.getPoint(),d);
                System.out.println("bojler");
                break;
            case "Kada":
                k = new Kada("kada"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KadaPainter(k,e.getPoint(),d);
                System.out.println("kada");
                break;
            case "Krevet":
                k = new Krevet("krevet"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KrevetPainter(k,e.getPoint(),d);
                System.out.println("krevet");
                break;
            case "Lavabo":
                k = new Lavabo("lavabo"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new LavaboPainter(k,e.getPoint(),d);
                System.out.println("lavabo");
                break;
            case "Ormar":
                k = new Ormar("ormar"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KrevetPainter(k,e.getPoint(),d);
                System.out.println("ormar");
                break;
            case "Sto":
                k = new Sto("sto"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KrevetPainter(k,e.getPoint(),d);
                break;
            case "Ves Masina":
                k = new VesMasina("ves masina"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KrevetPainter(k,e.getPoint(),d);
                break;
            case "Vrata":
                k = new Vrata("vrata"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new VrataPainter(k,e.getPoint(),d);
                break;
            case "WC solja":
                k = new WCSolja("WC solja"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new WCSoljaPainter(k,e.getPoint(),d);
                break;
            default:
                k = null;
                p = new KrevetPainter(k,e.getPoint(),d);
                System.out.println("nesto nije u redu");
        }
        for(ElementPainter ep: rv.getPainters()) {
            for(Shape shape: ep.getShapes()) {
                for(Shape shape1:p.getShapes()) {
                    if (shape.intersects(shape1.getBounds2D()))
                    {
                        ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"ne sme da se preklapa sa drugim elementom"));
                        return;
                    }
                }
            }
        }
        ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addRoomElement(k);
        rv.addPainter(p);

    }
}
