package raf.draft.dsw.state;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public interface State {
    void misPrevucen(MouseEvent e);
    void misOtpusten(MouseEvent e);
    void misSkrolGore(MouseWheelEvent e);
    void misSkrolDole(MouseWheelEvent e);
    void misPressed(MouseEvent e);
    void misKliknut(MouseEvent e);
}
