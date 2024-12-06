package raf.draft.dsw.model.roomobjects;

import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

public class Sto extends RoomElement {

    public Sto(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public Sto(String ime, DraftNode roditelj, Dimension dimenzija, Point locacija, Paint paint, double rotateRatio, Stroke stroke) {
        super(ime, roditelj, dimenzija, locacija, paint, rotateRatio, stroke);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new Sto(prototype.getNaziv(),null);
    }
}
