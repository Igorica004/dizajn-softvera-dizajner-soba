package raf.draft.dsw.tabbedpane.model;

import lombok.Data;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tree.DraftTreeImplementation;
import raf.draft.dsw.utils.ColorUtils;
import raf.draft.dsw.tabbedpane.view.TabPanel;
import raf.draft.dsw.utils.DraftNodeUtils;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;


@Data
public class TabbedPaneModel {
    private HashMap<DraftNode,TabPanel> sviTabovi = new HashMap<>();
    private HashMap<DraftNode,TabPanel> noviTabovi = new HashMap<>();

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
                        TabPanel tabPanel = new TabPanel(room);
                        noviTabovi.put(room, tabPanel);
                        sviTabovi.put(room, tabPanel);
                    }
                }
            }
            else{
                if(sviTabovi.containsKey(child)){
                    noviTabovi.put(child,sviTabovi.get(child));
                }
                else{
                    TabPanel tabPanel = new TabPanel(child);
                    noviTabovi.put(child, tabPanel);
                    sviTabovi.put(child, tabPanel);
                }
            }
        }
    }

    public HashMap<DraftNode,TabPanel> getTabovi(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        selektovan = DraftNodeUtils.getProjectParent(selektovan);
        DraftTreeImplementation stablo = (DraftTreeImplementation) MainFrame.getInstanca().getDraftTree();
        if(selektovan != stablo.getSelektovaniProjekat())
            return null;
        return noviTabovi;
    }


}
