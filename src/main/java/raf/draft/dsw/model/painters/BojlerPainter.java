package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;

import java.awt.*;
import java.awt.geom.Ellipse2D;

public class BojlerPainter extends DevicePainter{
    public BojlerPainter(RoomDevice roomDevice) {
        super(roomDevice);
        shape = new Ellipse2D.Double(roomDevice.getLokacija().x,roomDevice.getLokacija().y,roomDevice.getDimenzija().width,roomDevice.getDimenzija().width);

    }

    @Override
    public void setLokacija(Point lokacija) {
        ((RoomDevice)roomElement).setLokacija(lokacija);
        shape = new Ellipse2D.Double(((RoomDevice)roomElement).getLokacija().x,((RoomDevice)roomElement).getLokacija().y,
                                    ((RoomDevice)roomElement).getDimenzija().width,((RoomDevice)roomElement).getDimenzija().width);
    }
    @Override
    public void setDimenzija(Dimension dimenzija) {
        ((RoomDevice)roomElement).setDimenzija(dimenzija);
        shape = new Ellipse2D.Double(((RoomDevice)roomElement).getLokacija().x,((RoomDevice)roomElement).getLokacija().y,
                ((RoomDevice)roomElement).getDimenzija().width,((RoomDevice)roomElement).getDimenzija().width);
    }
}
