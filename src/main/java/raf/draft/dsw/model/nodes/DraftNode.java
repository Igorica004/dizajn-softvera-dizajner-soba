package raf.draft.dsw.model.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import raf.draft.dsw.model.roomobjects.*;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Room;

import java.awt.*;
import java.util.Objects;

@Data
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Room.class, name = "room"),
        @JsonSubTypes.Type(value = Building.class, name = "building"),
        @JsonSubTypes.Type(value = Bojler.class, name = "bojler"),
        @JsonSubTypes.Type(value = Kada.class, name = "kada"),
        @JsonSubTypes.Type(value = Lavabo.class, name = "lavabo"),
        @JsonSubTypes.Type(value = Ormar.class, name = "ormar"),
        @JsonSubTypes.Type(value = Sto.class, name = "sto"),
        @JsonSubTypes.Type(value = VesMasina.class, name = "vesmasina"),
        @JsonSubTypes.Type(value = Vrata.class, name = "vrata"),
        @JsonSubTypes.Type(value = WCSolja.class, name = "wcsolja"),
})
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
