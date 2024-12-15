package raf.draft.dsw.model.roomobjects;

import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

public class VesMasina extends RoomElement{

    public VesMasina(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public VesMasina(String ime, DraftNode roditelj, Paint paint, double rotateRatio, Stroke stroke) {
        super(ime, roditelj, paint, rotateRatio, stroke);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new VesMasina(prototype.getNaziv(),prototype.getRoditelj(), prototype.getPaint(), prototype.getRotateRatio(),prototype.getStroke());
    }
}
