package raf.draft.dsw.model.roomobjects;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.nodes.DraftLeaf;
import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;
@Getter
@Setter
public abstract class RoomElement extends DraftLeaf implements Prototype{
    protected Point locacija;
    protected Dimension dimenzija;
    protected double rotateRatio;
    protected Stroke stroke;
    protected Paint paint;

    public RoomElement(String ime, DraftNode roditelj, Dimension dimenzija, Point locacija, Paint paint, double rotateRatio, Stroke stroke) {
        super(ime, roditelj);
        this.dimenzija = dimenzija;
        this.locacija = locacija;
        this.paint = paint;
        this.rotateRatio = rotateRatio;
        this.stroke = stroke;
    }

    public RoomElement(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

}
