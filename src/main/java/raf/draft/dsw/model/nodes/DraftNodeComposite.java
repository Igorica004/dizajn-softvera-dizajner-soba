package raf.draft.dsw.model.nodes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
@NoArgsConstructor
public abstract class DraftNodeComposite extends DraftNode {
    private ArrayList<DraftNode> children;
    public void addChild(DraftNode child) {children.add(child);}
    public void removeChild(DraftNode child) {children.remove(child);}

    public DraftNodeComposite(String name, DraftNode parent) {
        super(name,parent);
        children = new ArrayList<>();
    }
}
