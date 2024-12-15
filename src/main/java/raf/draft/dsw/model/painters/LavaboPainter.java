package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class LavaboPainter extends ElementPainter {
    public LavaboPainter(RoomElement roomElement, Point lokacija, Dimension dimenzija) {
        super(roomElement, lokacija, dimenzija);
        initializeShape();
    }
    @Override
    public void initializeShape() {
        shapes.clear();
        GeneralPath shape = new GeneralPath();
        shape.moveTo(lokacija.x, lokacija.y);
        shape.lineTo(lokacija.x + dimenzija.width*scaleRatio, lokacija.y);
        shape.lineTo(lokacija.x + (dimenzija.width*scaleRatio)/2, lokacija.y+dimenzija.height*scaleRatio);
        shape.closePath();

        shapes.add(shape);
    }

}
