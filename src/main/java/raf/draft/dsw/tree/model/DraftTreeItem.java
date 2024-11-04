package raf.draft.dsw.tree.model;

import lombok.Getter;
import lombok.Setter;
import raf.draft.dsw.model.nodes.DraftNode;

import javax.swing.tree.DefaultMutableTreeNode;

@Getter
@Setter
public class DraftTreeItem extends DefaultMutableTreeNode {
    private DraftNode draftNode;

    public DraftTreeItem(DraftNode draftNode) {this.draftNode = draftNode;}

    @Override
    public String toString() {return draftNode.getIme();}

    public void setIme(String ime) {this.draftNode.setIme(ime);}
}
