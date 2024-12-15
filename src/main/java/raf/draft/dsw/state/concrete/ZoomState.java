package raf.draft.dsw.state.concrete;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.state.State;

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
    public void misSkrolGore(MouseWheelEvent e) {
        for(ElementPainter elementPainter :MainFrame.getInstanca().getDesniPanel().getSelectedTab().getPainters()){
            elementPainter.setScaleRatio(elementPainter.getScaleRatio()+e.getWheelRotation()*0.1);
        }
    }

    @Override
    public void misSkrolDole(MouseWheelEvent e) {

    }

    @Override
    public void misPritisnut(MouseEvent e) {

    }

    @Override
    public void misKliknut(MouseEvent e) {

    }
}
