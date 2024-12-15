package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;

public class KrevetPainter extends ElementPainter {
    public KrevetPainter(RoomElement roomElement, Point lokacija, Dimension dimenzija) {
        super(roomElement,lokacija,dimenzija);
        initializeShape();
    }

    @Override
    public void initializeShape() {
        shapes.clear();
        shapes.add(new Rectangle(lokacija,new Dimension((int)(dimenzija.width*scaleRatio),(int)(dimenzija.height*scaleRatio))));
        shapes.add(new Rectangle(new Point((int)(lokacija.x+0.1*dimenzija.width),(int)(lokacija.y+0.1*dimenzija.height)),new Dimension(dimenzija.width/3,dimenzija.height/3)));
    }

}
