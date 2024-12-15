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
    protected ArrayList<Shape> shapes = new ArrayList<>();
    protected Point lokacija;
    protected Dimension dimenzija;
    protected double rotateRatio;
    protected double scaleRatio;

    public ElementPainter(RoomElement element, Point lokacija, Dimension dimenzija) {
        this.lokacija = lokacija;
        this.roomElement = element;
        this.dimenzija = dimenzija;
    }
    public void paint(Graphics2D g) {
        for(Shape roomShape:shapes){
            g.setStroke(roomElement.getStroke());
            g.setPaint(roomElement.getPaint());
            g.rotate(rotateRatio, lokacija.x + 1.0*dimenzija.width/2,
                    lokacija.y + 1.0*dimenzija.height/2);
            g.fill(roomShape);
            g.setPaint(Color.black);
            g.draw(roomShape);
            g.rotate(-rotateRatio, lokacija.x + 1.0*dimenzija.width/2,
                    1.0*lokacija.y + 1.0*dimenzija.height/2);
        }
    }
    public abstract void initializeShape();
    public void setLokacija(Point lokacija){
        this.lokacija = lokacija;
        initializeShape();
    }
    public void setDimenzija(Dimension dimenzija){
        this.dimenzija = dimenzija;
        initializeShape();
    }
}
