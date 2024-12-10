package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.roomobjects.RoomDevice;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

public class MoveState implements State {
    int pocetniX, pocetniY;
    int razlikaX, razlikaY;
    private ArrayList<Point> stareKoordinate = new ArrayList<>();
    @Override
    public void misPrevucen(MouseEvent e) {
        int trenutniX = e.getX();
        int trenutniY = e.getY();
        razlikaX = trenutniX - pocetniX;
        razlikaY = trenutniY - pocetniY;

        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        int i = 0;
        for(ElementPainter r : rv.getSelektovani())
        {
            ((RoomDevice)r.getRoomElement()).setLokacija(new Point(razlikaX + stareKoordinate.get(i).x, razlikaY + stareKoordinate.get(i).y));
            i++;
        }
        rv.repaint();
    }

    @Override
    public void misOtpusten(MouseEvent e) {
        stareKoordinate.clear();
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
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        pocetniX=e.getX();
        pocetniY=e.getY();
        for(ElementPainter r: rv.getSelektovani())
        {
            stareKoordinate.add(new Point (((RoomDevice)r.getRoomElement()).getLokacija()));
        }
    }
}
