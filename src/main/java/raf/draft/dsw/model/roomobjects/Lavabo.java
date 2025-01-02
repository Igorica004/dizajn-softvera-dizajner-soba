package raf.draft.dsw.model.roomobjects;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.NoArgsConstructor;
import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.*;

@NoArgsConstructor
public class Lavabo extends RoomElement{
    public Lavabo(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public Lavabo(String ime, DraftNode roditelj, Color paint, double rotateRatio, BasicStroke stroke) {
        super(ime, roditelj, paint, rotateRatio, stroke);
    }

    @Override
    public Prototype clone(RoomElement prototype) {
        return new Lavabo(prototype.getNaziv(),prototype.getRoditelj(), prototype.getPaint(), prototype.getRotateRatio(),prototype.getStroke());
    }
}
