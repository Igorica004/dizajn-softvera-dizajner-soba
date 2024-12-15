package raf.draft.dsw.state;

import raf.draft.dsw.controller.observer.IPublisher;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public interface State extends IPublisher {
    void misPrevucen(MouseEvent e);
    void misOtpusten(MouseEvent e);
    void misSkrol(MouseWheelEvent e);
    void misPritisnut(MouseEvent e);
    void misKliknut(MouseEvent e);
}
