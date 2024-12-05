package raf.draft.dsw.model.factory;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Room;

import java.awt.*;

public class FactoryRoom extends Factory {

    @Override
    public DraftNode createNode(DraftNode parent, String ime, String autor, String putanja, Dimension dimenzija) {
        return new Room(ime,parent,dimenzija);
    }
}
