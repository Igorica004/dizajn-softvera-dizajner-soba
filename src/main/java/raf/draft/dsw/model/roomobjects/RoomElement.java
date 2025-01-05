package raf.draft.dsw.model.roomobjects;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftLeaf;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.utils.DraftNodeUtils;

import java.awt.*;
@Getter
@Setter
@NoArgsConstructor
public abstract class RoomElement extends DraftLeaf implements Prototype{
    protected double rotateRatio;
    protected BasicStroke stroke;
    protected Color paint;

    public RoomElement(String ime, DraftNode roditelj, Color paint, double rotateRatio, BasicStroke stroke) {
        super(ime, roditelj);
        this.paint = paint;
        this.rotateRatio = rotateRatio;
        this.stroke = stroke;
    }

    public RoomElement(String ime, DraftNode roditelj) {
        super(ime, roditelj);
    }
    public void setMenjan(){
        Project project = DraftNodeUtils.getProjectParent(this);
        if (project == null) {
            DraftTreeImplementation draftTree = ((DraftTreeImplementation)MainFrame.getInstanca().getDraftTree());
            project = DraftNodeUtils.getProjectParent(draftTree.getSelectedNode().getDraftNode());
        }
        project.setMenjan(true);
    }

}
