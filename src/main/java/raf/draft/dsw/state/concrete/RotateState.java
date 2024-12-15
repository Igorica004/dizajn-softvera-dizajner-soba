package raf.draft.dsw.state.concrete;

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

public class RotateState implements State {
    Point centarObjekta;
    @Override
    public void misPrevucen(MouseEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        int x = e.getX();
        int y = e.getY();
        double angle = Math.atan2(centarObjekta.y - y, centarObjekta.x - x) - Math.PI / 2;
        for(ElementPainter ep:rv.getSelektovani())
        {
            ep.setRotateRatio(angle);
        }
        rv.repaint();
    }

    @Override
    public void misOtpusten(MouseEvent e) {
        centarObjekta = null;
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
        if(rv.getSelektovani().size()!=1)
        {
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA, LocalDateTime.now(),"Nije selektovan objekat, ili ih ima vise"));
            return;
        }
        for(ElementPainter ep: rv.getSelektovani()) {
            centarObjekta = new Point(ep.getLokacija().x, ep.getLokacija().y);
        }
    }

    @Override
    public void misKliknut(MouseEvent e) {

    }
}
