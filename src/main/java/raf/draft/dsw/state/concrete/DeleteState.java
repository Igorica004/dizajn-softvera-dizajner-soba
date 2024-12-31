package raf.draft.dsw.state.concrete;

import raf.draft.dsw.controller.command.concrete.DeleteCommand;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;
import raf.draft.dsw.tree.DraftTreeImplementation;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class DeleteState implements State {

    private ArrayList<ISubscriber> subscribers = new ArrayList<>();
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
        Point p = e.getPoint();
        RoomView rv = MainFrame.getInstanca().getDesniPanel().getSelectedTab();
        rv.getCommandManager().addCommand(new DeleteCommand(p));

        notifySubscribers(null);
    }

    @Override
    public void misKliknut(MouseEvent e) {

    }

    @Override
    public void addSubscriber(ISubscriber sub) {
        subscribers.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscribers.remove(sub);
    }

    @Override
    public void notifySubscribers(Notification notification) {
        for(ISubscriber sub: subscribers)
            sub.update(null);
    }
}
