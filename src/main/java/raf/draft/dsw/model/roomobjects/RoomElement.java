package raf.draft.dsw.model.roomobjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import raf.draft.dsw.model.nodes.DraftLeaf;
import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;
@Getter
@Setter
@NoArgsConstructor
public abstract class RoomElement extends DraftLeaf implements Prototype{
    protected double rotateRatio;
    protected BasicStroke stroke;
    protected Color paint;

    public RoomElement(String ime, DraftNode roditelj, Color paint, double rotateRatio, BasicStroke stroke) {
        super(ime, roditelj);
        this.paint = paint;
        this.rotateRatio = rotateRatio;
        this.stroke = stroke;
    }

    public RoomElement(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

}
