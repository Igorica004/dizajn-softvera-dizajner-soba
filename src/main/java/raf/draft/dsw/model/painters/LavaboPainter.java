package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;

import java.awt.*;
import java.awt.geom.GeneralPath;

public class LavaboPainter extends DevicePainter{
    public LavaboPainter(RoomDevice roomDevice) {
        super(roomDevice);
        napraviShape(roomDevice);
    }
    private void napraviShape(RoomDevice roomDevice) {
        shape = new GeneralPath();
        ((GeneralPath)shape).moveTo(roomDevice.getLokacija().x, roomDevice.getLokacija().y);
        ((GeneralPath)shape).lineTo(roomDevice.getLokacija().x + roomDevice.getDimenzija().width, roomDevice.getLokacija().y+roomDevice.getDimenzija().height);
        ((GeneralPath)shape).lineTo(roomDevice.getLokacija().x + roomDevice.getDimenzija().width, roomDevice.getLokacija().y-roomDevice.getDimenzija().height);
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
