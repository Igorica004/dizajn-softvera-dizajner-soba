package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.model.nodes.DraftNode;

import javax.swing.*;

@Data
public class TabPanel extends JPanel {
    private DraftNode room;
    public TabPanel(DraftNode room) {this.room = room;}
}
