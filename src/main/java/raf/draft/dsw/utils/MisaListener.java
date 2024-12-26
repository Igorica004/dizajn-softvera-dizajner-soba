package raf.draft.dsw.utils;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.state.State;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MisaListener extends MouseAdapter {
    public MisaListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        State current = MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState();
        if(current != null)
            current.misPrevucen(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        State current = MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState();
        if(current != null)
            current.misPritisnut(e);

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        State current = MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState();
        if(current == null)
            return;
        current.misSkrol(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        State current = MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState();
        if(current != null)
            current.misOtpusten(e);
    }
}
