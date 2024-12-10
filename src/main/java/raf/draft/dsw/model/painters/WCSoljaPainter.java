package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class WCSoljaPainter extends DevicePainter{

    public WCSoljaPainter(RoomDevice roomDevice) {
        super(roomDevice);
        napraviShape(roomDevice);
    }

    private void napraviShape(RoomDevice roomDevice) {
        shape = new GeneralPath();
        ((GeneralPath)shape).moveTo(roomDevice.getLokacija().x, roomDevice.getLokacija().y);
        ((GeneralPath)shape).lineTo(roomDevice.getLokacija().x, roomDevice.getLokacija().y + roomDevice.getDimenzija().height/2);
        ((GeneralPath)shape).curveTo(((GeneralPath)shape).getCurrentPoint().getX(), ((GeneralPath)shape).getCurrentPoint().getY(),
                ((GeneralPath)shape).getCurrentPoint().getX() + roomDevice.getDimenzija().width/2, ((GeneralPath)shape).getCurrentPoint().getY() + roomDevice.getDimenzija().height/2,
                ((GeneralPath)shape).getCurrentPoint().getX() + roomDevice.getDimenzija().width, ((GeneralPath)shape).getCurrentPoint().getY());
        ((GeneralPath)shape).lineTo(roomDevice.getLokacija().x + roomDevice.getDimenzija().width, roomDevice.getLokacija().y);
        ((GeneralPath)shape).closePath();
    }

    @Override
    public void setLokacija(Point lokacija) {
        ((RoomDevice)roomElement).setLokacija(lokacija);
        napraviShape(((RoomDevice)roomElement));
    }

    @Override
    public void setDimenzija(Dimension dimenzija) {
        ((RoomDevice)roomElement).setDimenzija(dimenzija);
        napraviShape(((RoomDevice)roomElement));
    }
}
