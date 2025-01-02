package raf.draft.dsw.model.factory;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;

import java.awt.*;

public class FactoryBuilding extends Factory {

    @Override
    public DraftNode createNode(DraftNode parent, String ime, String autor, Dimension dimenzija) {
        return new Building(ime, parent);
    }
}

