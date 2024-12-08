package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.RoomDevice;

import java.awt.*;
@Getter
@Setter
public class DevicePainter extends ElementPainter {
    protected Shape shape;
    public DevicePainter(RoomDevice roomDevice) {
        super(roomDevice);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setPaint(Color.RED);

        g.setStroke(roomElement.getStroke());
        g.draw(shape);
        g.setPaint(roomElement.getPaint());

        g.fill(shape);
    }
}
