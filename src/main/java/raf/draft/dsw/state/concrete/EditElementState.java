package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.ProzorEditElement;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class EditElementState implements State {
    @Override
    public void misPrevucen(MouseEvent e) {

    }

    @Override
    public void misOtpusten(MouseEvent e) {

    }

    @Override
    public void misSkrol(MouseWheelEvent e) {

    }

    @Override
    public void misPritisnut(MouseEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        int x = e.getX();
        int y = e.getY();
        for(ElementPainter ep: rv.getPainters())
        {
            for(Shape shape: ep.getShapes()){
                if(shape.contains(x, y))
                {
                    ProzorEditElement prozor = new ProzorEditElement(ep);
                    prozor.setVisible(true);
                    prozor.setElement(ep);
                    rv.repaint();
                }
            }
        }
    }

    @Override
    public void misKliknut(MouseEvent e) {

    }
}
