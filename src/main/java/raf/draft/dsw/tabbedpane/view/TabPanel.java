package raf.draft.dsw.tabbedpane.view;

import lombok.Data;
import raf.draft.dsw.model.nodes.DraftNode;

import javax.swing.*;
import java.util.Objects;

@Data
public class TabPanel extends JPanel {
    private DraftNode room;
    public TabPanel(DraftNode room) {this.room = room;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TabPanel tabPanel)) return false;
        return Objects.equals(room, tabPanel.room);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(room);
    }
}
