package raf.draft.dsw.tree.view;

import lombok.Data;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

@Data
public class DraftTreeCellRender extends DefaultTreeCellRenderer {
    /*private Icon leaf;
    private Icon node;
    public DraftTreeCellRender() {
        super();
        leaf = new ImageIcon("/images/edit.png");
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
        setLeafIcon(this.leaf);
        return this;
    }*/
}
