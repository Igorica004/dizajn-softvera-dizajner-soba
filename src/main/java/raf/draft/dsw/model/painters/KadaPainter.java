package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class KadaPainter extends DevicePainter{
    public KadaPainter(RoomDevice prototype) {
        super(prototype);
        shape = new Ellipse2D.Double(prototype.getLokacija().x,prototype.getLokacija().y,prototype.getDimenzija().width,prototype.getDimenzija().height);
    }

    @Override
    public void setLokacija(Point lokacija) {
        ((RoomDevice)roomElement).setLokacija(lokacija);
        shape = new Ellipse2D.Double(((RoomDevice)roomElement).getLokacija().x,((RoomDevice)roomElement).getLokacija().y,((RoomDevice)roomElement).getDimenzija().width,((RoomDevice)roomElement).getDimenzija().height);
    }

    @Override
    public void setDimenzija(Dimension dimenzija) {
        ((RoomDevice)roomElement).setDimenzija(dimenzija);
        shape = new Ellipse2D.Double(((RoomDevice)roomElement).getLokacija().x,((RoomDevice)roomElement).getLokacija().y,((RoomDevice)roomElement).getDimenzija().width,((RoomDevice)roomElement).getDimenzija().height);
    }
}
