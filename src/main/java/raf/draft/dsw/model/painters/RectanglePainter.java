package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;

public class RectanglePainter extends ShapePainter {


    public RectanglePainter(Point lokacija, Rectangle rectangle) {
        super(lokacija);
        shape = rectangle;
    }

    @Override
    public void paint(Graphics2D g) {
        super.paint(g);
        Color c=new Color(0,0,1,0.9f );
        g.setColor(c);
        g.fill(shape);
    }
}
