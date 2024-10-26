package raf.draft.dsw.model.structures;

import lombok.Data;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
@Data
public class Project extends DraftNodeComposite {
    private String ime;
    private String autor;
    private String putanja;
}
