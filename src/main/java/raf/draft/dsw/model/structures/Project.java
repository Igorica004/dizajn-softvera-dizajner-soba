package raf.draft.dsw.model.structures;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;

@Getter
@Setter
@NoArgsConstructor
public class Project extends DraftNodeComposite {
    private boolean menjan = true;
    private String naziv;
    private String autor;
    private String putanja;
    public Project(String naziv, DraftNode roditelj){super(naziv,roditelj);}
    public Project(String autor, String naziv, DraftNode roditelj) {
        super(naziv, roditelj);
        this.naziv = naziv;
        this.autor = autor;
        this.putanja = putanja;
    }
}
