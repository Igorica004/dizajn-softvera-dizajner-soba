package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.model.factory.Prototype;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.RoomElement;
import raf.draft.dsw.model.painters.ElementPainter;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;
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
        Iterator<Prototype> i = ((Room)room).getObjects().iterator();
        while(i.hasNext()){
            RoomElement element = (RoomElement) i.next();
            //ElementPainter elementPainter = element.getPainter();
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
