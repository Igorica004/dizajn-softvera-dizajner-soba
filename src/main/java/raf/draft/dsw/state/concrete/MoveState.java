package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.roomobjects.RoomDevice;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MoveState implements State {
    int pocetniX, pocetniY;
    int noviX, noviY;
    @Override
    public void misPrevucen(MouseEvent e) {
        int trenutniX = e.getX();
        int trenutniY = e.getY();
        noviX = trenutniX - pocetniX;
        noviY = trenutniY - pocetniY;
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        for(RoomElement r:rv.getSelektovani()){
            Point p = new Point(((RoomDevice)r).getLokacija().x + noviX, ((RoomDevice)r).getLokacija().y + noviY);
            ((RoomDevice)r).setLokacija(p);
            rv.repaint();
        }
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
    public void misKliknut(MouseEvent e) {

    }

    @Override
    public void misPressed(MouseEvent e) {
        pocetniX=e.getX();
        pocetniY=e.getY();
    }
}
