package raf.draft.dsw.model.structures;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;

@Getter
@Setter
public class Project extends DraftNodeComposite {
    private String naziv;
    private String autor;
    private String putanja;
    public Project(String naziv, DraftNode roditelj){super(naziv,roditelj);}
    public Project(String autor, String naziv, String putanja, DraftNode roditelj) {
        super(naziv, roditelj);
        this.naziv = naziv;
        this.autor = autor;
        this.putanja = putanja;
    }
}
