package raf.draft.dsw.model.roomobjects;

import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

public class Vrata extends RoomElement{
    public Vrata(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public Vrata(String ime, DraftNode roditelj, Paint paint, double rotateRatio, Stroke stroke) {
        super(ime, roditelj, paint, rotateRatio, stroke);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new Vrata(prototype.getNaziv(),prototype.getRoditelj(), prototype.getPaint(), prototype.getRotateRatio(),prototype.getStroke());
    }
}
