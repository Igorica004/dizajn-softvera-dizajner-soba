package raf.draft.dsw.model.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Room;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Room.class, name = "room"),
        @JsonSubTypes.Type(value = Building.class, name = "building")
})
public abstract class DraftNodeComposite extends DraftNode {
    private ArrayList<DraftNode> children;
    public void addChild(DraftNode child) {children.add(child);}
    public void removeChild(DraftNode child) {children.remove(child);}

    public DraftNodeComposite(String name, DraftNode parent) {
        super(name,parent);
        children = new ArrayList<>();
    }
}
