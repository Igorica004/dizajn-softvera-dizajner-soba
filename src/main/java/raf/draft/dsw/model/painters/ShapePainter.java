package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.model.shapes.RoomShape;

import java.awt.*;
@Getter
@Setter
abstract class ShapePainter extends ElementPainter {
    protected Point lokacija;
    protected Dimension dimenzija;

    public ShapePainter(Point lokacija, RoomShape shape1) {
        super(null,lokacija);
        this.lokacija = lokacija;
        shapes.add(shape1);
    }
}
