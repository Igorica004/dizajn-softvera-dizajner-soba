package raf.draft.dsw.model.painters;

import raf.draft.dsw.model.roomobjects.RoomDevice;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.model.shapes.RoomRectangle;

import java.awt.*;
import java.util.List;

public class KrevetPainter extends DevicePainter{
    public KrevetPainter(RoomElement roomElement) {
        super(roomElement);
        //shape = new Rectangle(roomDevice.getLokacija(),roomDevice.getDimenzija());
    }

    @Override
    public void azurirajVelicine() {
        shapes.add(new RoomRectangle(lokacija,dimenzija));
    }
    //@Override
    //public void setLokacija(Point lokacija) {
    //    ((RoomDevice)roomElement).setLokacija(lokacija);
    //    shape = new Rectangle(((RoomDevice)roomElement).getLokacija(),((RoomDevice)roomElement).getDimenzija());
    //}
    //@Override
    //public void setDimenzija(Dimension dimenzija) {
    //    ((RoomDevice)roomElement).setDimenzija(dimenzija);
    //    shape = new Rectangle(((RoomDevice)roomElement).getLokacija(),((RoomDevice)roomElement).getDimenzija());
    //}

}
