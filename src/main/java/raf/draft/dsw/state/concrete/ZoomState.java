package raf.draft.dsw.state.concrete;

import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.AffineTransform;
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
        Point zoomAnchor = e.getPoint();
        rv.setPrevZoomFactor(rv.getZoomFactor());
        double yOffset;
        if(e.getWheelRotation()<0)
        {
            rv.setZoomFactor(rv.getZoomFactor()*1.1);

        }
        if(e.getWheelRotation()>0)
        {
            rv.setZoomFactor(rv.getZoomFactor()/1.1);

        }
        rv.setTransform(new AffineTransform());
        double zoomDiv = rv.getZoomFactor() / rv.getPrevZoomFactor();
        rv.setXOffset ((zoomDiv) * (rv.getXOffset()) + (1 - zoomDiv) * zoomAnchor.getX());
        rv.setYOffset((zoomDiv) * (rv.getYOffset()) + (1 - zoomDiv) * zoomAnchor.getY());
        rv.getTransform().translate(rv.getXOffset(), rv.getYOffset());
        rv.getTransform().scale(rv.getZoomFactor(), rv.getZoomFactor());
        rv.repaint();
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
