package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;

import java.awt.*;

public class KrevetPainter extends DevicePainter{
    public KrevetPainter(RoomDevice roomDevice) {
        super(roomDevice);
        shape = new Rectangle(roomDevice.getLokacija(),roomDevice.getDimenzija());
    }
    @Override
    public void setLokacija(Point lokacija) {
        ((RoomDevice)roomElement).setLokacija(lokacija);
        shape = new Rectangle(((RoomDevice)roomElement).getLokacija(),((RoomDevice)roomElement).getDimenzija());
    }
    @Override
    public void setDimenzija(Dimension dimenzija) {
        ((RoomDevice)roomElement).setDimenzija(dimenzija);
        shape = new Rectangle(((RoomDevice)roomElement).getLokacija(),((RoomDevice)roomElement).getDimenzija());
    }
}
