package raf.draft.dsw.model.roomobjects;

import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

public class Kada extends RoomElement{
    public Kada(String ime, DraftNode roditelj, Dimension dimenzija, Point locacija, Paint paint, double rotateRatio, Stroke stroke) {
        super(ime, roditelj, dimenzija, locacija, paint, rotateRatio, stroke);
    }

    public Kada(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new Kada(prototype.getNaziv(),null);
    }
}
