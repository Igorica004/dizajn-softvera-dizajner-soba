package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.painters.RectanglePainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import static java.lang.Math.abs;

public class SelectState implements State {
    Rectangle r = new Rectangle();
    RectanglePainter p = new RectanglePainter(new Point(1,1),new Dimension(1,1));
    Point klik = new Point();

    @Override
    public void misPrevucen(MouseEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        updateSize(e);

    }

    @Override
    public void misOtpusten(MouseEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        rv.getPainters().remove(p);
        selektuj(rv);
        System.out.println(rv.getSelektovani());
        rv.repaint();
    }

    @Override
    public void misSkrolGore(MouseWheelEvent e) {

    }

    @Override
    public void misSkrolDole(MouseWheelEvent e) {

    }

    @Override
    public void misPritisnut(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        klik.setLocation(x, y);
        p.setDimenzija(new Dimension(0,0));
        p.setLokacija(klik);
        r.setLocation(klik);
        r.setSize(new Dimension(1,1));

        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        rv.removeSelektovani();
        selektuj(rv);

        rv.addPainter(p);
    }

    @Override
    public void misKliknut(MouseEvent e) {
    }

    public void selektuj(RoomView rv){
        for(ElementPainter ep : rv.getPainters()) {
            for(Shape shape: ep.getShapes()) {
                if(r.intersects(shape.getBounds2D())){
                    rv.addSelektovani(ep);
                    (ep.getRoomElement()).setStroke(new BasicStroke(3));
                }
            }
        }
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
        p.setDimenzija(new Dimension(r.width,r.height));
        p.setLokacija(new Point(r.x,r.y));
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        rv.repaint();
    }
}
