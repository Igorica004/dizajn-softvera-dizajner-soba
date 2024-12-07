package raf.draft.dsw.state.concrete;

import raf.draft.dsw.state.State;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class SelectState implements State {
    Rectangle r = null;
    @Override
    public void misPrevucen(MouseEvent e, Graphics2D g2d) {
        updateSize(e, g2d);
        System.out.println("drag");
    }

    @Override
    public void misOtpusten(MouseEvent e, Graphics2D g2d) {
        updateSize(e, g2d);
    }

    @Override
    public void misSkrolGore(MouseWheelEvent e, Graphics2D g2d) {

    }

    @Override
    public void misSkrolDole(MouseWheelEvent e, Graphics2D g2d) {

    }

    @Override
    public void misPressed(MouseEvent e, Graphics2D g2d) {
        int x = e.getX();
        int y = e.getY();
        r = new Rectangle(x, y, 0, 0);
        g2d.drawRect(x, y, 10, 10);
        System.out.println("pres");
    }

    void updateSize(MouseEvent e, Graphics2D g2d) {
        int x = e.getX();
        int y = e.getY();
        r = new Rectangle(x, y, 0, 0);
        r.setSize(x - r.x, y - r.y);
        g2d.drawRect(r.x, r.y, r.width, r.height);
        //currentRect.setSize(x - currentRect.x,
        //                       y - currentRect.y);
    }
}
