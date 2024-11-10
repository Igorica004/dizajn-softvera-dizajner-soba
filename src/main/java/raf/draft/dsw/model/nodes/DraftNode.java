package raf.draft.dsw.model.nodes;

import lombok.Data;

import java.awt.*;

@Data
public abstract class DraftNode {
    private String naziv;
    private DraftNode roditelj;
    private Color color;

    public DraftNode(String naziv, DraftNode roditelj) {
        this.naziv = naziv;
        this.roditelj = roditelj;
    }
}
