package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.RectanglePainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import static java.lang.Math.abs;

public class SelectState implements State {
    Rectangle r;
    RectanglePainter p;

    @Override
    public void misPrevucen(MouseEvent e) {
        updateSize(e);
    }

    @Override
    public void misOtpusten(MouseEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        updateSize(e);
        while(!rv.getPainters().isEmpty() && rv.getPainters().getLast() instanceof RectanglePainter) {
            rv.removePainter(rv.getPainters().getLast());
        }
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
        r = new Rectangle(x,y,0,0);

        p = new RectanglePainter(new Point(x,y),r);
    }

    @Override
    public void misKliknut(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());

    }

    void updateSize(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        r.setSize(x - r.x, y - r.y);
//        if(r.width <0) {
//            r.width = -r.width;
//            r.x =- r.width;
//        }
//        if(r.height <0) {
//            r.height = -r.height;
//            r.y =- r.height;
//        }

        p.setShape(r);
        ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent()).addPainter(p);
        //currentRect.setSize(x - currentRect.x,
        //                       y - currentRect.y);
    }
}
