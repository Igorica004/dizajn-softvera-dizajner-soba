package raf.draft.dsw.model.painters;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.model.shapes.RoomShape;

import java.awt.*;
import java.util.ArrayList;

@Getter
@Setter
public abstract class ElementPainter {
    protected RoomElement roomElement;
    protected ArrayList<RoomShape> shapes = new ArrayList<>();
    protected Point lokacija;
    protected Dimension dimenzija;
    public ElementPainter(RoomElement element, Point lokacija) {
        this.lokacija = lokacija;
        this.roomElement = element;
    }
    public abstract void paint(Graphics2D g);

}
