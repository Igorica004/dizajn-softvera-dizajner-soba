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
import java.util.ArrayList;
import java.util.Objects;

@Data
public class RoomView extends JPanel {
    private Room room;
    private ArrayList<DevicePainter> painters = new ArrayList<>();
    public RoomView(Room room) {
        this();
        this.room = room;
    }
    public RoomView(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawRect(10,10,room.getDimenzija().width,room.getDimenzija().height);
        /*g2d.setPaint(Color.BLACK);
        g2d.drawRect(10, 0, getWidth(), getHeight());
        g2d.fillRect(10, 0, 25, 25);*/

//        for(RoomElement r:((Room)room).getObjects())
//        {
//            if(r instanceof Krevet)
//            {
//                painters.add(new KrevetPainter((Krevet)r));
//            }
//            else
//            {
//                painters.add(new KrevetPainter((Krevet)r));
//            }
//
//        }
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
