package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;

public class RectanglePainter extends ShapePainter {

    public RectanglePainter(Point lokacija, Rectangle rectangle) {
        super(lokacija,rectangle);
    }

    @Override
    public void paint(Graphics2D g) {
        Color c=new Color(0,0,1, 128);
        g.setColor(c);
        g.fill(shape);
    }
}
