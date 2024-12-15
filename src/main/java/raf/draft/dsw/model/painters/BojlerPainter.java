package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class BojlerPainter extends ElementPainter {

    public BojlerPainter(RoomElement roomElement, Point lokacija, Dimension dimenzija) {
        super(roomElement, lokacija, dimenzija);
        initializeShape();
    }
    @Override
    public void initializeShape(){
        shapes.clear();
        shapes.add(new Ellipse2D.Double(lokacija.x, lokacija.y, dimenzija.width*scaleRatio, dimenzija.height*scaleRatio));
        GeneralPath g = new GeneralPath();
        g.moveTo(lokacija.x, lokacija.y);
        g.lineTo(lokacija.x + dimenzija.width*scaleRatio, lokacija.y+ dimenzija.height*scaleRatio);
        g.moveTo(lokacija.x + dimenzija.width*scaleRatio, lokacija.y);
        g.lineTo(lokacija.x, lokacija.y + dimenzija.height*scaleRatio);
        shapes.add(g);
    }
}
