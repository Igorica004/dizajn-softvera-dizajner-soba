package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;

import java.awt.geom.Ellipse2D;

public class BojlerPainter extends DevicePainter{
    public BojlerPainter(RoomDevice roomDevice) {
        super(roomDevice);
        shape = new Ellipse2D.Double(roomDevice.getLokacija().x,roomDevice.getLokacija().y,roomDevice.getDimenzija().width,roomDevice.getDimenzija().width);
    }
}
