package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class KadaPainter extends ElementPainter {
    public KadaPainter(RoomElement roomElement, Point lokacija, Dimension dimenzija) {
        super(roomElement, lokacija, dimenzija);
        initializeShape();
    }

    @Override
    public void initializeShape() {
        shapes.clear();
       shapes.add(new Ellipse2D.Double(lokacija.x,lokacija.y,dimenzija.width*scaleRatio,dimenzija.height*scaleRatio));
    }
}
