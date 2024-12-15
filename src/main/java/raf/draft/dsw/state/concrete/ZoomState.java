package raf.draft.dsw.state.concrete;

import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

public class ZoomState implements State {

    private ArrayList<ISubscriber> subscribers = new ArrayList<>();
    @Override
    public void misPrevucen(MouseEvent e) {

    }

    @Override
    public void misOtpusten(MouseEvent e) {

    }

    @Override
    public void misSkrol(MouseWheelEvent e) {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        if(e.getWheelRotation()<0)
        {
            rv.setZoomFactor(rv.getZoomFactor()*1.1);
            for(ElementPainter ep:rv.getPainters())
            {
                ep.setScaleRatio(rv.getZoomFactor()*1.1);
            }
        }
        if(e.getWheelRotation()>0)
        {
            rv.setZoomFactor(rv.getZoomFactor()/1.1);
            for(ElementPainter ep:rv.getPainters())
            {
                ep.setScaleRatio(rv.getZoomFactor()/1.1);
            }
        }
        rv.repaint();
        System.out.println("skorl");
    }

    @Override
    public void misPritisnut(MouseEvent e) {

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
