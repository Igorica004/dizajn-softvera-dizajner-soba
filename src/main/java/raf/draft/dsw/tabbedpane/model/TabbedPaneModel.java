package raf.draft.dsw.tabbedpane.model;

import lombok.Data;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.utils.ColorUtils;
import raf.draft.dsw.tabbedpane.view.TabPanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;

@Data
public class TabbedPaneModel {
    private HashMap<DraftNode,ArrayList<TabPanel>> sviTabovi = new HashMap<>();
    //private HashMap<DraftNode,Color> projektneBoje = new HashMap<>();
    //public Color getBojaProjekta(){
    //    DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
    //    if(!projektneBoje.containsKey(selektovan))
    //        projektneBoje.put(selektovan, ColorUtils.randomColor());
    //    return projektneBoje.get(selektovan);
    //}

    public void update(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        if(selektovan instanceof Building)
            selektovan = selektovan.getRoditelj();
        else if(!(selektovan instanceof Project))
            return;
        ArrayList<TabPanel> stariTabovi = new ArrayList<>();
        ArrayList<TabPanel> tabovi = new ArrayList<>();
        if(sviTabovi.containsKey(selektovan))
            stariTabovi = sviTabovi.get(selektovan);
        for (DraftNode child : ((Project) selektovan).getChildren()) {
            if(child instanceof Building build)
                for(DraftNode room:build.getChildren()){
                    if(stariTabovi.contains(new TabPanel(room))){
                        for(TabPanel tp:stariTabovi){
                            if(tp.getRoom().equals(room))
                                tabovi.add(tp);
                        }
                    }
                    else{
                        tabovi.add(new TabPanel(room));
                    }
                }
            else{
                if(stariTabovi.contains(new TabPanel(child))) {
                    for(TabPanel tp:stariTabovi){
                        if(tp.getRoom().equals(child))
                            tabovi.add(tp);
                    }
                }
                else{
                    tabovi.add(new TabPanel(child));
                }
            }
        }
        sviTabovi.put(selektovan, tabovi);
    }
    public ArrayList<TabPanel> getTabovi(){
        DraftNode selektovan = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        if(selektovan instanceof Building)
            selektovan = selektovan.getRoditelj();
        return sviTabovi.get(selektovan);
    }
}
