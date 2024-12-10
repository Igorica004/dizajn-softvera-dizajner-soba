package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
@Getter
@Setter
public class RectanglePainter extends ShapePainter {

    public RectanglePainter(Point lokacija, Rectangle rectangle) {
        super(lokacija,rectangle);
    }

    @Override
    public void paint(Graphics2D g) {
        Color c=new Color(0,0,1, 128);
        g.setColor(c);
        g.fill(shape);
    }
}
