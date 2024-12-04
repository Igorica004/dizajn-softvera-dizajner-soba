package raf.draft.dsw.tabbedpane.model;

import lombok.Data;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;
import raf.draft.dsw.utils.DraftNodeUtils;

import java.util.HashMap;


@Data
public class TabbedPaneModel {
    private HashMap<DraftNode, RoomView> sviTabovi = new HashMap<>();
    private HashMap<DraftNode, RoomView> noviTabovi = new HashMap<>();

    //1. nalazenje projekta
    //2. od projekta se spustati ka dole 
    public void update(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        if(DraftNodeUtils.getProjectParent(selektovan) == null){
            return;
        }
        Project project = DraftNodeUtils.getProjectParent(selektovan);
        noviTabovi.clear();
        for(DraftNode child:project.getChildren()){
            if(child instanceof Building build){
                for(DraftNode room:build.getChildren()){
                    if(sviTabovi.containsKey(room)){
                        noviTabovi.put(room,sviTabovi.get(room));
                    }
                    else{
                        RoomView roomView = new RoomView(room);
                        noviTabovi.put(room, roomView);
                        sviTabovi.put(room, roomView);
                    }
                }
            }
            else{
                if(sviTabovi.containsKey(child)){
                    noviTabovi.put(child,sviTabovi.get(child));
                }
                else{
                    RoomView roomView = new RoomView(child);
                    noviTabovi.put(child, roomView);
                    sviTabovi.put(child, roomView);
                }
            }
        }
    }

    public HashMap<DraftNode, RoomView> getTabovi(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        selektovan = DraftNodeUtils.getProjectParent(selektovan);
        DraftTreeImplementation stablo = (DraftTreeImplementation) MainFrame.getInstanca().getDraftTree();
        if(selektovan != stablo.getSelektovaniProjekat())
            return null;
        return noviTabovi;
    }


}
