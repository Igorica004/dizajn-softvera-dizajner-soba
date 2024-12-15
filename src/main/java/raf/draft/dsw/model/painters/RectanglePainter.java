package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.Krevet;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
@Getter
@Setter
public class RectanglePainter extends ElementPainter {

    public RectanglePainter(Point lokacija, Dimension dimenzija) {
        super(new Krevet("krevet", null,
                Color.RED, 0, new BasicStroke(BasicStroke.CAP_BUTT)),new Point(15,15),new Dimension(1,1));
        initializeShape();
    }

    @Override
    public void paint(Graphics2D g) {
        Color c=new Color(0,0,1, 128);
        g.setColor(c);
        g.fill(shapes.getFirst());
    }

    @Override
    public void initializeShape() {
        shapes.clear();
        shapes.add(new Rectangle(lokacija,dimenzija));
    }
}
