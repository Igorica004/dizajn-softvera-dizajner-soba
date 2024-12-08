package raf.draft.dsw.state.concrete;

import raf.draft.dsw.state.State;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class MoveState implements State {
    int x,y;
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
    public void misKliknut(MouseEvent e) {

    }

    @Override
    public void misPressed(MouseEvent e) {
        x=e.getX();
        y=e.getY();

    }
}
