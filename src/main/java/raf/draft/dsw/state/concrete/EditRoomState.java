package raf.draft.dsw.state.concrete;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.ProzorDimenzijeSobe;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.painters.RectanglePainter;
import raf.draft.dsw.state.State;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.time.LocalDateTime;

public class EditRoomState implements State {
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
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());
        ProzorDimenzijeSobe prozor = new ProzorDimenzijeSobe();
        prozor.setVisible(true);
        int x,y;
        try {
            x = Integer.parseInt(prozor.getTfDimenzijaX().getText());
            y = Integer.parseInt(prozor.getTfDimenzijaY().getText());
        } catch (Exception ex) {
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Nisu dobre dimenzije sobe"));
            return;
        }
        Dimension d = new Dimension(x, y);
        rv.getRoom().setDimenzija(d);
        rv.getOkvirSobe().setLokacija(new Point(10,10));
        //rv.getOkvirSobe().setShape(new Rectangle(10,10,(int)(rv.getRoom().getDimenzija().width*rv.getScale()),
        //        (int)(rv.getRoom().getDimenzija().height*rv.getScale())));
        rv.getOkvirSobe().setDimenzija(new Dimension(x,y));
        rv.repaint();
    }
}
