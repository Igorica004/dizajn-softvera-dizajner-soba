package raf.draft.dsw.model.nodes;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.awt.*;
@Getter
@Setter
public abstract class RoomElement extends DraftLeaf {
    protected Point locacija;
    protected Dimension dimenzija;
    double rotateRatio;


    public RoomElement(String ime, DraftNode roditelj, Dimension dimenzija, Point locacija, double rotateRatio) {
        super(ime, roditelj);
        this.dimenzija = dimenzija;
        this.locacija = locacija;
        this.rotateRatio = rotateRatio;
    }

    public RoomElement(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }
}
