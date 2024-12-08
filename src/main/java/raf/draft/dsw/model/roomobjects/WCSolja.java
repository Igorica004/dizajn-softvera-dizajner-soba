package raf.draft.dsw.model.roomobjects;

import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

public class WCSolja extends RoomDevice{
    public WCSolja(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public WCSolja(String ime, DraftNode roditelj, Dimension dimenzija, Point lokacija, Paint paint, double rotateRatio, Stroke stroke) {
        super(ime, roditelj, dimenzija, lokacija, paint, rotateRatio, stroke);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new WCSolja(prototype.getNaziv(),null);
    }
}
