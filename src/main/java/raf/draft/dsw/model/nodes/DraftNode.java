package raf.draft.dsw.model.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.NoArgsConstructor;
import raf.draft.dsw.model.structures.Building;

import java.awt.*;
import java.util.Objects;

@Data
@NoArgsConstructor
public abstract class DraftNode {
    private String naziv;
    @JsonIgnore
    private DraftNode roditelj;
    private Color color;
    private String putanja;

    private void initializePutanja(){
        if(roditelj == null)
            return;
        String putanja = naziv;
        putanja = String.format("%s/%s",roditelj.getNaziv(),putanja);
        if(roditelj instanceof Building){
            putanja = String.format("%s/%s",roditelj.getRoditelj().getNaziv(),putanja);
        }
        this.putanja = putanja;
    }

    public void setRoditelj(DraftNode roditelj) {
        this.roditelj = roditelj;
        initializePutanja();
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
        initializePutanja();
    }

    public DraftNode(String naziv, DraftNode roditelj) {
        this.naziv = naziv;
        this.roditelj = roditelj;
        initializePutanja();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DraftNode draftNode)) return false;
        return Objects.equals(putanja, draftNode.putanja);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(putanja);
    }
}
