package raf.draft.dsw.model.nodes;

import lombok.Data;

@Data
public abstract class DraftNode {
    private String ime;
    private DraftNode roditelj;

    public DraftNode(String ime, DraftNode roditelj) {
        this.ime = ime;
        this.roditelj = roditelj;
    }
}
