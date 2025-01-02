package raf.draft.dsw.model.roomobjects;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.NoArgsConstructor;
import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

@NoArgsConstructor
public class WCSolja extends RoomElement{
    public WCSolja(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public WCSolja(String ime, DraftNode roditelj, Color paint, double rotateRatio, BasicStroke stroke) {
        super(ime, roditelj, paint, rotateRatio, stroke);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new WCSolja(prototype.getNaziv(),prototype.getRoditelj(), prototype.getPaint(), prototype.getRotateRatio(),prototype.getStroke());
    }
}
