package raf.draft.dsw.model.nodes;

import lombok.Data;

import java.awt.*;

@Data
public abstract class DraftNode extends Component {
    private String ime;
    private DraftNode roditelj;
    private Color color;

    public DraftNode(String ime, DraftNode roditelj) {
        this.ime = ime;
        this.roditelj = roditelj;
    }
}
