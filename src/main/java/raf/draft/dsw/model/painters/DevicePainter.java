package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.RoomDevice;

import java.awt.*;
@Getter
@Setter
public class DevicePainter extends ElementPainter {
    public DevicePainter(RoomDevice roomDevice) {
        super(roomDevice,roomDevice.getLokacija());
    }

    @Override
    public void paint(Graphics2D g) {
        g.setStroke(roomElement.getStroke());
        g.setPaint(roomElement.getPaint());
        g.rotate(roomElement.getRotateRatio(), ((RoomDevice)roomElement).getLokacija().x + ((RoomDevice)roomElement).getDimenzija().width/2,
                                                ((RoomDevice)roomElement).getLokacija().y + ((RoomDevice)roomElement).getDimenzija().height/2);
        g.fill(shape);
        g.setPaint(Color.black);
        g.draw(shape);
        g.rotate(-roomElement.getRotateRatio(), ((RoomDevice)roomElement).getLokacija().x + ((RoomDevice)roomElement).getDimenzija().width/2,
                ((RoomDevice)roomElement).getLokacija().y + ((RoomDevice)roomElement).getDimenzija().height/2);
    }

    public void setDimenzija(Dimension dimenzija) {
        ((RoomDevice)roomElement).setDimenzija(dimenzija);
    }
}
