package raf.draft.dsw.model.factory;

import raf.draft.dsw.model.nodes.DraftNode;

public abstract class Factory {
    public abstract DraftNode createNode(DraftNode parent, String naziv, String autor, String putanja);
}
