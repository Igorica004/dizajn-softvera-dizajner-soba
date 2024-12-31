package raf.draft.dsw.controller.command.concrete;

import raf.draft.dsw.controller.command.AbstractCommand;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.painters.*;
import raf.draft.dsw.model.roomobjects.*;
import raf.draft.dsw.tabbedpane.view.RoomView;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.tree.model.DraftTreeItem;

import java.awt.*;
import java.time.LocalDateTime;

public class AddCommand extends AbstractCommand {
    private Point point;
    RoomElement k;
    ElementPainter painter;
    public AddCommand(Point p)
    {
        point = p;
    }
    @Override
    public void doCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        if(k!=null)
        {
            ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addRoomElement(k);
            rv.addPainter(painter);
            return;
        }
        String s = MainFrame.getInstanca().getDesniPanel().getElementToAdd();
        Dimension d = new Dimension(MainFrame.getInstanca().getDesniPanel().getDimensionToAdd());

        d.width*=rv.getScale();
        d.height*=rv.getScale();

        DraftTreeItem room = new DraftTreeItem(rv.getRoom());
        switch (s) {
            case "Bojler":
                k = new Bojler("bojler"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                painter = new BojlerPainter(k,point,d);
                System.out.println("bojler");
                break;
            case "Kada":
                k = new Kada("kada"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                painter = new KadaPainter(k,point,d);
                System.out.println("kada");
                break;
            case "Krevet":
                k = new Krevet("krevet"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                painter = new KrevetPainter(k,point,d);
                System.out.println("krevet");
                break;
            case "Lavabo":
                k = new Lavabo("lavabo"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                painter = new LavaboPainter(k,point,d);
                System.out.println("lavabo");
                break;
            case "Ormar":
                k = new Ormar("ormar"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                painter = new KrevetPainter(k,point,d);
                System.out.println("ormar");
                break;
            case "Sto":
                k = new Sto("sto"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                painter = new KrevetPainter(k,point,d);
                break;
            case "Ves Masina":
                k = new VesMasina("ves masina"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                painter = new KrevetPainter(k,point,d);
                break;
            case "Vrata":
                k = new Vrata("vrata"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                painter = new VrataPainter(k,point,d);
                break;
            case "WC solja":
                k = new WCSolja("WC solja"+room.getChildCount(), rv.getRoom(),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                painter = new WCSoljaPainter(k,point,d);
                break;
            default:
                k = null;
                painter = new KrevetPainter(k,point,d);
                System.out.println("nesto nije u redu");
        }
        for(ElementPainter ep: rv.getPainters()) {
            for(Shape shape: ep.getShapes()) {
                for(Shape shape1:painter.getShapes()) {
                    if (shape.intersects(shape1.getBounds2D()))
                    {
                        ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA, LocalDateTime.now(),"ne sme da se preklapa sa drugim elementom"));
                        return;
                    }
                }
            }
        }
        ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).addRoomElement(k);
        rv.addPainter(painter);
    }

    @Override
    public void undoCommand() {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        rv.removePainter(painter);
        ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree()).removeRoomElement(k);
    }
}
