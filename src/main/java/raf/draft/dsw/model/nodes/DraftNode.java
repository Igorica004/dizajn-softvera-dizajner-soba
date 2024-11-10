package raf.draft.dsw.model.nodes;

import lombok.Data;

import java.awt.*;
import java.util.Objects;

@Data
public abstract class DraftNode {
    private String naziv;
    private DraftNode roditelj;
    private Color color;

    public DraftNode(String naziv, DraftNode roditelj) {
        this.naziv = naziv;
        this.roditelj = roditelj;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DraftNode draftNode = (DraftNode) o;
        return Objects.equals(naziv, draftNode.naziv);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(naziv);
    }
}
