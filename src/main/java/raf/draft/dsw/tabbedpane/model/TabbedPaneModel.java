package raf.draft.dsw.tabbedpane.model;

import lombok.Data;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tabbedpane.ColorUtils;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

@Data
public class TabbedPaneModel {
    private HashMap<DraftNode,ArrayList<DraftNode>> sviTabovi = new HashMap<>();
    private HashMap<DraftNode,Color> projektneBoje = new HashMap<>();
    public Color getBojaProjekta(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        if(!projektneBoje.containsKey(selektovan))
            projektneBoje.put(selektovan, ColorUtils.randomColor());
        return projektneBoje.get(selektovan);
    }

    public void update(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        ArrayList<DraftNode> stariTabovi = new ArrayList<>();
        ArrayList<DraftNode> tabovi = new ArrayList<>();
        if(sviTabovi.containsKey(selektovan))
            stariTabovi = sviTabovi.get(selektovan);
        HashMap<Building, Color> boje = new HashMap<>();
        for(DraftNode building: ((Project) selektovan).getChildren()){
            if(building instanceof Building build){
                if(!boje.containsKey(build)){
                    boje.put(build, ColorUtils.randomColor());
                }
            }
        }
        for (DraftNode child : ((Project) selektovan).getChildren()) {
            if(child instanceof Building build)
                for(DraftNode room:build.getChildren()){
                    if(!stariTabovi.contains(room)){
                        room.setColor(boje.get(build));
                    }
                    tabovi.add(room);
                }
            else{
                if(!stariTabovi.contains(child)) {
                    child.setColor(getBojaProjekta());
                }
                tabovi.add(child);
            }
        }
        sviTabovi.put(selektovan, tabovi);
    }
    public ArrayList<DraftNode> getTabovi(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        return sviTabovi.get(selektovan);
    }
}
