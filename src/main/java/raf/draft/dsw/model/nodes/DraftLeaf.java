package raf.draft.dsw.model.nodes;

import lombok.NoArgsConstructor;

@NoArgsConstructor
public abstract class DraftLeaf extends DraftNode {
    public DraftLeaf(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }
}
