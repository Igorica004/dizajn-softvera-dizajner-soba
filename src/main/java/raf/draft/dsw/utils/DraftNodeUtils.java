package raf.draft.dsw.utils;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.structures.Project;

public class DraftNodeUtils {
    public static boolean nameIsValid(DraftNode draftNode){
        if(draftNode == null || draftNode.getRoditelj() == null)
            return true;
        for(DraftNode child:((DraftNodeComposite)draftNode.getRoditelj()).getChildren()){
            if(child.equals(draftNode))
                return false;
        }
        return true;
    }
    public static Project getProjectParent(DraftNode child){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        while(selektovan != null && !(selektovan instanceof Project)){
            selektovan = selektovan.getRoditelj();
        }
        if(selektovan instanceof Project project){
            return project;
        }
        return null;
    }
}
