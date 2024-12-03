package raf.draft.dsw.model.structures;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.roomobjects.Prototype;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.roomobjects.RoomElement;

import java.awt.*;
import java.util.ArrayList;
@Getter
@Setter
public class Room extends DraftNodeComposite {
    Dimension dimenzija; //1cm = ~37.8px
    private ArrayList<RoomElement> objects = new ArrayList<>();
    public Room(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }

    public Room(String ime, DraftNode roditelj, Dimension dimenzija) {
        super(ime, roditelj);
        this.dimenzija = dimenzija;
    }
    public void addObject(RoomElement object) {
        objects.add(object);
    }
}
