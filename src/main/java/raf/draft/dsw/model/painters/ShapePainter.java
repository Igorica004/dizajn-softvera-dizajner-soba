package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
@Getter
@Setter
abstract class ShapePainter extends ElementPainter {
    protected Point lokacija;
    protected Dimension dimenzija;

    public ShapePainter(Point lokacija, Shape shape1) {
        super(null);
        this.lokacija = lokacija;
        shape = shape1;
    }
}
