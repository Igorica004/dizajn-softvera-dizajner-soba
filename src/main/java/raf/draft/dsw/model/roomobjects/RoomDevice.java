package raf.draft.dsw.model.roomobjects;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;
import java.awt.geom.Dimension2D;
@Getter
@Setter
public class RoomDevice extends RoomElement{
    public Dimension dimenzija;
    public Point lokacija;
    public RoomDevice(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public RoomDevice(String ime, DraftNode roditelj, Dimension dimenzija, Point lokacija, Paint paint, double rotateRatio, Stroke stroke) {
        super(ime, roditelj, paint, rotateRatio, stroke);
        this.dimenzija = dimenzija;
        this.lokacija = lokacija;
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return null;
    }
}
