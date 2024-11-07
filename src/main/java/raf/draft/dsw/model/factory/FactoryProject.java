package raf.draft.dsw.model.factory;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;

public class FactoryProject extends Factory {

    //napraviti da moze i da se napravi sa parametrima za autora i putanju
    @Override
    public DraftNode createNode(DraftNode parent, String ime, String autor, String putanja) {
        return new Project(autor, parent, ime, putanja);
    }
}
