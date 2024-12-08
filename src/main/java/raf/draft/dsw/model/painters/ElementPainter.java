package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;

public abstract class ElementPainter {
    RoomElement roomElement;
    public ElementPainter(RoomElement element) {
        this.roomElement = element;
    }
    public abstract void paint(Graphics2D g);

}
