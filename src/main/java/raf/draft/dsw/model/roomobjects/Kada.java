package raf.draft.dsw.model.roomobjects;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.NoArgsConstructor;
import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

@NoArgsConstructor
public class Kada extends RoomElement{
    public Kada(String ime, DraftNode roditelj, Color paint, double rotateRatio, BasicStroke stroke) {
        super(ime, roditelj, paint, rotateRatio, stroke);
    }

    public Kada(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new Kada(prototype.getNaziv(),prototype.getRoditelj(), prototype.getPaint(), prototype.getRotateRatio(),prototype.getStroke());
    }
}
