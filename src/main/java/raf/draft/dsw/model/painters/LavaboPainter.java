package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;

import java.awt.geom.GeneralPath;

public class LavaboPainter extends DevicePainter{
    public LavaboPainter(RoomDevice roomDevice) {
        super(roomDevice);
        shape = new GeneralPath();
        napraviShape(roomDevice);
    }
    private void napraviShape(RoomDevice roomDevice) {
        ((GeneralPath)shape).moveTo(roomDevice.getLokacija().x, roomDevice.getLokacija().y);
        ((GeneralPath)shape).lineTo(roomDevice.getLokacija().x + roomDevice.getDimenzija().width, roomDevice.getLokacija().y+roomDevice.getDimenzija().height);
        ((GeneralPath)shape).lineTo(roomDevice.getLokacija().x + roomDevice.getDimenzija().width, roomDevice.getLokacija().y-roomDevice.getDimenzija().height);
        ((GeneralPath)shape).closePath();
    }
}
