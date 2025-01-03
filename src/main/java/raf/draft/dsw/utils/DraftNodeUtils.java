package raf.draft.dsw.utils;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;

import java.util.ArrayList;

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
    public static ArrayList<Room> getRooms(Project project){
        ArrayList<Room> rooms = new ArrayList<>();
        for(DraftNode draftNode:project.getChildren()){
            if(draftNode instanceof Room){
                rooms.add((Room)draftNode);
            }
            else{
                Building building = (Building)draftNode;
                for(DraftNode child:building.getChildren()){
                    rooms.add((Room)child);
                }
            }
        }
        return rooms;
    }
}
