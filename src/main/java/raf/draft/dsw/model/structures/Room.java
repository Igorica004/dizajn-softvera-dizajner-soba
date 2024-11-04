package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftLeaf;
import raf.draft.dsw.model.nodes.DraftNode;

public class Room extends DraftLeaf {

    public Room(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }
}
