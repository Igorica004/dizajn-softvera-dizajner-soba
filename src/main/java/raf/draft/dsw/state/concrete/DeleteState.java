package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.Iterator;

public class DeleteState implements State {
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
        int x = e.getX();
        int y = e.getY();
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        Iterator<ElementPainter> iterator = rv.getPainters().iterator();

        while (iterator.hasNext()) {
            ElementPainter ep = iterator.next();
            if(ep.getShape().contains(x, y))
            {
                iterator.remove();
            }
        }
        for(ElementPainter ep: rv.getSelektovani())
        {
            rv.getPainters().remove(ep);
        }
        rv.repaint();
    }

    @Override
    public void misKliknut(MouseEvent e) {

    }
}
