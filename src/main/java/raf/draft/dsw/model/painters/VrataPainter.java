package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
import java.awt.geom.Arc2D;
import java.util.List;

public class VrataPainter extends ElementPainter {
    public VrataPainter(RoomElement roomElement, Point lokacija, Dimension dimenzija) {
        super(roomElement, lokacija, dimenzija);
        initializeShape();
    }

    @Override
    public void initializeShape() {
        shapes.clear();
        shapes.add(new Arc2D.Double(lokacija.x, lokacija.y, dimenzija.width*2, dimenzija.width*2, 90, 90, Arc2D.PIE));
    }
}
