package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.model.painters.DevicePainter;
import raf.draft.dsw.model.painters.KadaPainter;
import raf.draft.dsw.model.painters.KrevetPainter;
import raf.draft.dsw.model.roomobjects.*;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.util.Objects;

@Data
public class RoomView extends JPanel {
    private DraftNode room;
    public RoomView(DraftNode room) {
        this();
        this.room = room;
    }
    public RoomView(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        DevicePainter painter;

        /*g2d.setPaint(Color.BLACK);
        g2d.drawRect(10, 0, 25, 25);
        g2d.fillRect(10, 0, 25, 25);*/
//        if(((Room)room).getObjects()!=null){
//            KrevetPainter k = new KrevetPainter(new Krevet("krevet",room,new Dimension(25,25),new Point(10,10),Color.BLACK,2.2,new BasicStroke()));
//            k.paint(g2d);
//        }

        for(RoomElement r:((Room)room).getObjects())
        {
            if(r instanceof Krevet)
            {
                painter = new KrevetPainter((Krevet)r);
            }
            else
            {
                painter = new KadaPainter((Kada)r);
            }
            painter.paint(g2d);
        }
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
}
