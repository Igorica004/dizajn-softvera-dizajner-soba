package raf.draft.dsw.state.concrete;

import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.ProzorEditElement;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

public class EditElementState implements State {

    private ArrayList<ISubscriber> subscribers = new ArrayList<>();
    @Override
    public void misPrevucen(MouseEvent e) {

    }

    @Override
    public void misOtpusten(MouseEvent e) {

    }

    @Override
    public void misSkrolGore(MouseWheelEvent e) {

    }

    @Override
    public void misSkrolDole(MouseWheelEvent e) {

    }

    @Override
    public void misPritisnut(MouseEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        int x = e.getX();
        int y = e.getY();
        for(ElementPainter ep: rv.getPainters())
        {
            for(Shape shape: ep.getShapes()){
                if(shape.contains(x, y))
                {
                    ProzorEditElement prozor = new ProzorEditElement(ep);
                    prozor.setVisible(true);
                    prozor.setElement(ep);
                    notifySubscribers(null);
                }
            }
        }
    }

    @Override
    public void misKliknut(MouseEvent e) {

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
