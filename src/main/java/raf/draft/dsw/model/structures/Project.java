package raf.draft.dsw.model.structures;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.nodes.DraftNode;

@Getter
@Setter
public class Project extends DraftNode {
    private String ime;
    private String autor;
    private String putanja;
    public Project(String ime, DraftNode roditelj){super(ime,roditelj);}
    public Project(String ime, DraftNode roditelj, String autor, String putanja) {
        super(ime, roditelj);
        this.ime = ime;
        this.autor = autor;
        this.putanja = putanja;
    }
}
