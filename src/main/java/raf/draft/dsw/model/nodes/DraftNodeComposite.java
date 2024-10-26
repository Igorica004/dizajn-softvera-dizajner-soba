package raf.draft.dsw.model.nodes;

import java.util.ArrayList;

public abstract class DraftNodeComposite extends DraftNode {
    private ArrayList<DraftNode> children;
    public void addChild(DraftNode child) {children.add(child);}
    public void removeChild(DraftNode child) {children.remove(child);}
}
