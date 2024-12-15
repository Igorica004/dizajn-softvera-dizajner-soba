package raf.draft.dsw.state.concrete;

import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class MoveState implements State {

    private ArrayList<ISubscriber> subscribers = new ArrayList<>();
    int pocetniX, pocetniY;
    private ArrayList<Point> stareKoordinate = new ArrayList<>();
    @Override
    public void misPrevucen(MouseEvent e) {
        int trenutniX = e.getX();
        int trenutniY = e.getY();
        int razlikaX = trenutniX - pocetniX;
        int razlikaY = trenutniY - pocetniY;

        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        int i = 0;
        for(ElementPainter r : rv.getSelektovani())
        {
            //((RoomDevice)r.getShape()).setLokacija(new Point(razlikaX + stareKoordinate.get(i).x, razlikaY + stareKoordinate.get(i).y));
            r.setLokacija(new Point(stareKoordinate.get(i).x + razlikaX, stareKoordinate.get(i).y + razlikaY));
            i++;
        }
        notifySubscribers(null);
    }

    @Override
    public void misOtpusten(MouseEvent e) {
        boolean ok = true;
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        for(ElementPainter elementPainter:rv.getSelektovani()){
            for(Shape shape: elementPainter.getShapes()){
                for(ElementPainter elementPainter1:rv.getPainters()){
                    for(Shape shape1:elementPainter1.getShapes()){
                        if(elementPainter != elementPainter1 && shape.intersects(shape1.getBounds2D())){
                            ok = false;
                            break;
                        }
                    }
                }
            }
        }
        if(!ok){
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA, LocalDateTime.now(), "Elementi se seku"));
            int i=0;
            for(ElementPainter r : rv.getSelektovani())
            {
                r.setLokacija(stareKoordinate.get(i));
                i++;
            }
            notifySubscribers(null);

        }
        stareKoordinate.clear();
    }

    @Override
    public void misSkrol(MouseWheelEvent e) {

    }

    @Override
    public void misKliknut(MouseEvent e) {

    }

    @Override
    public void misPritisnut(MouseEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        pocetniX=e.getX();
        pocetniY=e.getY();
        for(ElementPainter r: rv.getSelektovani())
        {
            stareKoordinate.add(new Point (r.getLokacija()));
        }
    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Notification notification) {
        for(ISubscriber sub: subscribers)
            sub.update(null);
    }
}
