package raf.draft.dsw.model.roomobjects;

import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

public class Krevet extends RoomElement{

    public Krevet(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public Krevet(String ime, DraftNode roditelj, Paint paint, double rotateRatio, Stroke stroke) {
        super(ime, roditelj, paint, rotateRatio, stroke);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new Krevet(prototype.getNaziv(),prototype.getRoditelj(),prototype.getPaint(), prototype.getRotateRatio(),prototype.getStroke());
    }
}
