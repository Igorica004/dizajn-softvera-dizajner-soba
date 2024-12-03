package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.Prototype;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
@Getter
@Setter
public class DevicePainter extends ElementPainter {
    protected Shape shape;
    public DevicePainter(RoomElement prototype) {
        super(prototype);
    }

    @Override
    public void paint(Graphics2D g) {
        g.setPaint(Color.RED);

        g.setStroke(prototype.getStroke());
        g.draw(shape);
        g.setPaint(prototype.getPaint());

        g.fill(shape);
    }
}
