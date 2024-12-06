package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.geom.Ellipse2D;

public class KadaPainter extends DevicePainter{
    public KadaPainter(RoomElement prototype) {
        super(prototype);
        shape = new Ellipse2D.Double(prototype.getLokacija().x,prototype.getLokacija().y,prototype.getDimenzija().width,prototype.getDimenzija().height);
    }
}
