package raf.draft.dsw.model.roomobjects;

import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

public class Vrata extends RoomDevice{
    public Vrata(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public Vrata(String ime, DraftNode roditelj, Dimension dimenzija, Point lokacija, Paint paint, double rotateRatio, Stroke stroke) {
        super(ime, roditelj, dimenzija, lokacija, paint, rotateRatio, stroke);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new Vrata(prototype.getNaziv(), null);
    }
}
