package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
@Getter
@Setter
public class ShapePainter extends ElementPainter {
    protected Point lokacija;
    protected Dimension dimenzija;
    protected Shape shape;

    public ShapePainter(Point lokacija) {
        super(null);
        this.lokacija = lokacija;
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.black);
        g.draw(shape);
    }
}
