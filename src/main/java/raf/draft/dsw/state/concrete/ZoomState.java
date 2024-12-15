package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class ZoomState implements State {
    @Override
    public void misPrevucen(MouseEvent e) {

    }

    @Override
    public void misOtpusten(MouseEvent e) {

    }

    @Override
    public void misSkrol(MouseWheelEvent e) {
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        if(e.getWheelRotation()<0)
        {
            rv.setZoomFactor(rv.getZoomFactor()*1.1);
            for(ElementPainter ep:rv.getPainters())
            {
                ep.setScaleRatio(rv.getZoomFactor()*1.1);
            }
        }
        if(e.getWheelRotation()>0)
        {
            rv.setZoomFactor(rv.getZoomFactor()/1.1);
            for(ElementPainter ep:rv.getPainters())
            {
                ep.setScaleRatio(rv.getZoomFactor()/1.1);
            }
        }
        rv.repaint();
        System.out.println("skorl");
    }

    @Override
    public void misPritisnut(MouseEvent e) {

    }

    @Override
    public void misKliknut(MouseEvent e) {

    }
}
