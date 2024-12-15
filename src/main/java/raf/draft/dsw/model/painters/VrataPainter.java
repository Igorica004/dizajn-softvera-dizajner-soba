package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.util.List;

public class VrataPainter extends DevicePainter {
    public VrataPainter(RoomDevice roomDevice) {
        super(roomDevice);
        shapes.addAll(List.of(new Arc2D.Double(roomDevice.getLokacija().x, roomDevice.getLokacija().y, roomDevice.getDimenzija().width*2, roomDevice.getDimenzija().width*2, 90, 90, Arc2D.PIE));
    }

    @Override
    public void setLokacija(Point lokacija) {
        ((RoomDevice)roomElement).setLokacija(lokacija);
        shape = new Arc2D.Double(((RoomDevice)roomElement).getLokacija().x, ((RoomDevice)roomElement).getLokacija().y, ((RoomDevice)roomElement).getDimenzija().width*2, ((RoomDevice)roomElement).getDimenzija().width*2, 90, 90, Arc2D.PIE);
    }

    @Override
    public void setDimenzija(Dimension dimenzija) {
        ((RoomDevice)roomElement).setDimenzija(dimenzija);
        shape = new Arc2D.Double(((RoomDevice)roomElement).getLokacija().x, ((RoomDevice)roomElement).getLokacija().y, ((RoomDevice)roomElement).getDimenzija().width*2, ((RoomDevice)roomElement).getDimenzija().width*2, 90, 90, Arc2D.PIE);
    }
}
