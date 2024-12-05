package raf.draft.dsw.model.factory;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;

import java.awt.*;

public class FactoryProject extends Factory {

    //napraviti da moze i da se napravi sa parametrima za autora i putanju
    @Override
    public DraftNode createNode(DraftNode parent, String ime, String autor, String putanja, Dimension dimenzija) {
        return new Project(autor, ime, putanja, parent);
    }
}
