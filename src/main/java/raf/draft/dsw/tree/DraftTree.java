package raf.draft.dsw.tree;

import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.tree.model.DraftTreeItem;
import raf.draft.dsw.tree.view.DraftTreeView;

public interface DraftTree {
    DraftTreeView genrateTree(ProjectExplorer projectExplorer);
    void addChild();
    DraftTreeItem getSelectedNode();
}
