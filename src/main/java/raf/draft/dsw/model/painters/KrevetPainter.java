package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;

import java.awt.*;

public class KrevetPainter extends DevicePainter{
    public KrevetPainter(RoomDevice roomDevice) {
        super(roomDevice);
        shape = new Rectangle(roomDevice.getLokacija(),roomDevice.getDimenzija());
    }
}
