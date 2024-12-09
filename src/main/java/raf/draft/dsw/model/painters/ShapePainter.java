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
    protected Shape shape;

    public ShapePainter(Point lokacija, Shape shape) {
        super(null);
        this.lokacija = lokacija;
        this.shape = shape;
    }
}
