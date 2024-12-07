package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.painters.DevicePainter;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.util.ArrayList;
import java.util.Objects;

@Data
public class RoomView extends JPanel {
    private Room room;
    private ArrayList<DevicePainter> painters = new ArrayList<>();
    private Graphics2D g2d;
    public RoomView(Room room) {
        this();
        this.room = room;
        addMouseListener(new MisaListener());
        addMouseMotionListener(new MisaListener());
    }
    public RoomView(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g2d = (Graphics2D) g;
        g2d.drawRect(10,10,room.getDimenzija().width,room.getDimenzija().height);
        g2d.setPaint(Color.BLUE);
        g2d.setComposite(AlphaComposite.SrcOver.derive(0.6f));

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoomView roomView)) return false;
        return Objects.equals(room, roomView.room);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(room);
    }

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
            MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState().misPrevucen(e,g2d);
        }

        @Override
        public void mousePressed(MouseEvent e) {
            super.mousePressed(e);

            MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState().misPressed(e,g2d);

        }

        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            super.mouseWheelMoved(e);
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            super.mouseReleased(e);
            repaint();
            MainFrame.getInstanca().getDesniPanel().getStateManager().getCurrentState().misOtpusten(e,g2d);
        }
    }
}
