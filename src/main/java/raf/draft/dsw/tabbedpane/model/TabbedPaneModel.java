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
    private HashMap<DraftNode,HashMap<DraftNode, RoomView>> sviTabovi = new HashMap<>();
    //private HashMap<DraftNode,Color> projektneBoje = new HashMap<>();
    //public Color getBojaProjekta(){
    //    DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
    //    if(!projektneBoje.containsKey(selektovan))
    //        projektneBoje.put(selektovan, ColorUtils.randomColor());
    //    return projektneBoje.get(selektovan);
    //}

    //1. nalazenje projekta
    //2. od projekta se spustati ka dole 
    public void update(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        if(DraftNodeUtils.getProjectParent(selektovan) == null){
            return;
        }
        Project project = DraftNodeUtils.getProjectParent(selektovan);
        HashMap<DraftNode, RoomView> stariTabovi = sviTabovi.get(project);
        HashMap<DraftNode, RoomView> noviTabovi = new HashMap<>();
        if(stariTabovi == null){
            stariTabovi = new HashMap<>();
        }

        for(DraftNode child:project.getChildren()){
            if(child instanceof Building build){
                for(DraftNode room:build.getChildren()){
                    if(stariTabovi.containsKey(room)){
                        noviTabovi.put(room,(RoomView)stariTabovi.get(room));
                    }
                    else{
                        noviTabovi.put(room, new RoomView(room));
                    }
                }
            }
            else{
                if(stariTabovi.containsKey(child)){
                    noviTabovi.put(child,(RoomView)stariTabovi.get(child));
                }
                else{
                    noviTabovi.put(child, new RoomView(child));
                }
            }
        }
        sviTabovi.put(project, noviTabovi);
    }

    public HashMap<DraftNode, RoomView> getTabovi(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        selektovan = DraftNodeUtils.getProjectParent(selektovan);
        DraftTreeImplementation stablo = (DraftTreeImplementation) MainFrame.getInstanca().getDraftTree();
        if(selektovan != stablo.getSelektovaniProjekat())
            return null;
        return sviTabovi.get(selektovan);
    }


}
