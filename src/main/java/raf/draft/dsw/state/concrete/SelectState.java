package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.painters.RectanglePainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import static java.lang.Math.abs;

public class SelectState implements State {
    Rectangle r = new Rectangle();
    RectanglePainter p = new RectanglePainter(null,null);
    Point klik = new Point();

    @Override
    public void misPrevucen(MouseEvent e) {
        updateSize(e);
    }

    @Override
    public void misOtpusten(MouseEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        //updateSize(e);
        //while(!rv.getPainters().isEmpty() && rv.getPainters().getLast() instanceof RectanglePainter) {
        //    rv.removePainter(rv.getPainters().getLast());
        //}
        rv.getPainters().remove(p);
        rv.repaint();
    }

    @Override
    public void misSkrolGore(MouseWheelEvent e) {

    }

    @Override
    public void misSkrolDole(MouseWheelEvent e) {

    }

    @Override
    public void misPressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        klik.setLocation(x, y);
        r.setLocation(x, y);
        r.setSize(0,0);
        p.setShape(r);
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        rv.addPainter(p);
    }

    @Override
    public void misKliknut(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
    }

    void updateSize(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        r.setSize(x - klik.x, y - klik.y);
        if(r.width <0) {
            r.width = -r.width;
            r.x = x;
        }
        if(r.height <0) {
            r.height = -r.height;
            r.y = y;
        }

        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        for(ElementPainter ep : rv.getPainters()) {
            if(ep == p)
                ((RectanglePainter)ep).setShape(r);
        }
        rv.repaint();
    }
}
