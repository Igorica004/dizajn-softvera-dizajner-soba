package raf.draft.dsw.model.factory;

import raf.draft.dsw.model.nodes.DraftNode;

public class FactoryUtils {
    public static Factory getFactory(DraftNode draftNode){return new FactoryProject();}
}
