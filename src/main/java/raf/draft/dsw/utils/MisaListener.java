package raf.draft.dsw.utils;

import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MisaListener extends MouseAdapter {
    public MisaListener() {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        super.mouseDragged(e);
        MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState().misPrevucen(e);
    }

    @Override
    public void mousePressed(MouseEvent e) {
        super.mousePressed(e);

        MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState().misPressed(e);

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        super.mouseWheelMoved(e);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        super.mouseReleased(e);
        MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState().misOtpusten(e);
    }
}
