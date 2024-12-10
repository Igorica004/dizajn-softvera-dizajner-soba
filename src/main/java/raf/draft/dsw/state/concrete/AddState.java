package raf.draft.dsw.state.concrete;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.NoviObjekatProzor;
import raf.draft.dsw.gui.swing.ProzorGreska;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.painters.*;
import raf.draft.dsw.model.roomobjects.*;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.time.LocalDateTime;

public class AddState implements State {

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
    public void misPritisnut(MouseEvent e) {

        String s = MainFrame.getInstanca().getDesniPanel().getElementToAdd();
        Dimension d = MainFrame.getInstanca().getDesniPanel().getDimensionToAdd();
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        d.width*=rv.getScale();
        d.height*=rv.getScale();
        RoomDevice k;
        DevicePainter p;
        switch (s) {
            case "Bojler":
                k = new Bojler("bojler", null,
                        d, new Point(e.getX(), e.getY()),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new BojlerPainter(k);
                System.out.println("bojler");
                break;
            case "Kada":
                k = new Kada("kada", null,
                        d, new Point(e.getX(), e.getY()),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KadaPainter(k);
                System.out.println("kada");
                break;
            case "Krevet":
                k = new Krevet("krevet", null,
                        d, new Point(e.getX(), e.getY()),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KrevetPainter(k);
                System.out.println("krevet");
                break;
            case "Lavabo":
                k = new Lavabo("lavabo", null,
                        d, new Point(e.getX(), e.getY()),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new LavaboPainter(k);
                System.out.println("lavabo");
                break;
            case "Ormar":
                k = new Ormar("ormar", null,
                        d, new Point(e.getX(), e.getY()),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KrevetPainter(k);
                System.out.println("ormar");
                break;
            case "Sto":
                k = new Sto("sto", null,
                        d, new Point(e.getX(), e.getY()),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KrevetPainter(k);
                break;
            case "Ves Masina":
                k = new VesMasina("ves masina", null,
                        d, new Point(e.getX(), e.getY()),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new KrevetPainter(k);
                break;
            case "Vrata":
                k = new Vrata("vrata", null,
                        d, new Point(e.getX(), e.getY()),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new VrataPainter(k);
                break;
            case "WC solja":
                k = new WCSolja("WC solja", null,
                        d, new Point(e.getX(), e.getY()),
                        Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT));
                p = new WCSoljaPainter(k);
                break;
            default:
                k = null;
                p = new KrevetPainter(k);
                System.out.println("nesto nije u redu");
        }
        ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent()).addPainter(p);

    }
}
