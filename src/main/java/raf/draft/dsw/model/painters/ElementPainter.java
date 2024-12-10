package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
@Getter
@Setter
public abstract class ElementPainter {
    protected RoomElement roomElement;
    protected Shape shape;
    protected Point lokacija;
    public ElementPainter(RoomElement element, Point lokacija) {
        this.lokacija = lokacija;
        this.roomElement = element;
    }
    public abstract void paint(Graphics2D g);

}
