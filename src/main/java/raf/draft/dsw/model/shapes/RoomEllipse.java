package raf.draft.dsw.model.shapes;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class RoomEllipse extends Ellipse2D.Double implements RoomShape {
    public RoomEllipse(double x, double y, double width, double height) {
        super(x, y, width, height);
    }
    @Override
    public void setSize(int width, int height) {

    }

    @Override
    public void setScale(double scale) {

    }

}
