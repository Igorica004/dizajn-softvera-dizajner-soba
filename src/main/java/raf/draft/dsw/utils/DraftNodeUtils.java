package raf.draft.dsw.utils;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tree.model.DraftTreeItem;

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
        while(child != null && !(child instanceof Project)){
            child = child.getRoditelj();
        }
        if(child instanceof Project project){
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
    public static DraftTreeItem createDraftTreeItem(DraftNode draftNode){
        if(draftNode instanceof RoomElement)
            return new DraftTreeItem(draftNode);
        DraftTreeItem draftTreeItem = new DraftTreeItem(draftNode);
        for(DraftNode child: ((DraftNodeComposite)draftNode).getChildren()){
            draftTreeItem.add(createDraftTreeItem(child));
        }
        return draftTreeItem;
    }
}
