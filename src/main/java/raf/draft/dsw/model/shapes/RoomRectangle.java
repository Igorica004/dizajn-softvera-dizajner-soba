package raf.draft.dsw.model.shapes;

import java.awt.*;

public class RoomRectangle extends Rectangle implements RoomShape{

    Dimension dimenzija = new Dimension();
    double scale=1;
    @Override
    public void setScale(double scale) {
        this.scale = scale;
        height = (int)(dimenzija.height*scale);
        width = (int)(dimenzija.width*scale);
    }
    public RoomRectangle(Point p, Dimension dimenzija) {
        super(p, dimenzija);
        dimenzija.height = height;
        dimenzija.width = width;
    }

}
