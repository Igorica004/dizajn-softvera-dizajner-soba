package raf.draft.dsw.state;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public interface State {
    void misPrevucen(MouseEvent e, Graphics2D g2d);
    void misOtpusten(MouseEvent e, Graphics2D g2d);
    void misSkrolGore(MouseWheelEvent e, Graphics2D g2d);
    void misSkrolDole(MouseWheelEvent e, Graphics2D g2d);
    void misPressed(MouseEvent e, Graphics2D g2d);
}
