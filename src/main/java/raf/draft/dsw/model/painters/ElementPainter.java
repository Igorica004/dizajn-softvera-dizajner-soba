package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.Prototype;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;

public abstract class ElementPainter {
    protected RoomElement prototype;
    public ElementPainter(RoomElement prototype) {
        this.prototype = prototype;
    }
    public abstract void paint(Graphics2D g);
}
