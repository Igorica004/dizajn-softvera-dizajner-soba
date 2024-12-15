package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;

public class ResizeState implements State {
    int pocetniX, pocetniY;
    private ArrayList<Dimension> stareDimenzije = new ArrayList<>();
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
            r.setDimenzija(new Dimension(stareDimenzije.get(i).width + razlikaX, stareDimenzije.get(i).height + razlikaY));
            i++;
        }
        rv.repaint();
    }

    @Override
    public void misOtpusten(MouseEvent e) {
        stareDimenzije.clear();
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
    public void misPritisnut(MouseEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        pocetniX=e.getX();
        pocetniY=e.getY();
        for(ElementPainter r: rv.getSelektovani())
        {
            stareDimenzije.add(new Dimension (r.getDimenzija()));
        }
    }
}
