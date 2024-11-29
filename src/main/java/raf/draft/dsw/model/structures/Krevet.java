package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.factory.Prototype;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.RoomElement;

import java.awt.*;

public class Krevet extends RoomElement implements Prototype {


    public Krevet(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public Krevet(String ime, DraftNode roditelj, Dimension dimenzija, Point locacija, double rotateRatio) {
        super(ime, roditelj, dimenzija, locacija, rotateRatio);
    }

    @Override
    public Prototype clone() {
        return new Krevet("aa", null);
    }
}
