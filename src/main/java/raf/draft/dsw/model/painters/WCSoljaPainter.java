package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class WCSoljaPainter extends ElementPainter {

    public WCSoljaPainter(RoomElement roomElement, Point lokacija, Dimension dimenzija) {
        super(roomElement,lokacija,dimenzija);
    }

    @Override
    public void initializeShape() {
        shapes.clear();
        GeneralPath shape = new GeneralPath();
        shape.moveTo(lokacija.x, lokacija.y);
        shape.lineTo(lokacija.x, lokacija.y + 1.0*dimenzija.height/2);
        shape.curveTo(shape.getCurrentPoint().getX(), shape.getCurrentPoint().getY(),
                shape.getCurrentPoint().getX() + 1.0*dimenzija.width/2, shape.getCurrentPoint().getY() + 1.0*dimenzija.height/2,
                shape.getCurrentPoint().getX() + dimenzija.width, shape.getCurrentPoint().getY());
        shape.lineTo(lokacija.x + dimenzija.width, lokacija.y);
        shape.closePath();
        shapes.add(shape);

    }
}
