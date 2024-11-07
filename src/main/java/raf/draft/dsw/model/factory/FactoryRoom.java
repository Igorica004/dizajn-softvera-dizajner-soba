package raf.draft.dsw.model.factory;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Room;

public class FactoryRoom extends Factory {

    @Override
    public DraftNode createNode(DraftNode parent, String ime, String autor, String putanja) {
        return new Room(ime,parent);
    }
}
