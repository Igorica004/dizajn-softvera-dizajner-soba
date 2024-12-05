package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ProzorDimenzijeSobe;
import raf.draft.dsw.gui.swing.ProzorNoviBuildingRoom;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Room;

import java.awt.*;

public class NoviBuildingRoomAkcija {
    Dimension dimenzija = null;
    public DraftNode getDraftNode(){
        ProzorNoviBuildingRoom prozorNoviBuildingRoom = new ProzorNoviBuildingRoom("Make");
        prozorNoviBuildingRoom.setVisible(true);
        DraftNode dn = prozorNoviBuildingRoom.getDraftNode();
        if(dn instanceof Room){
            ProzorDimenzijeSobe pds = new ProzorDimenzijeSobe();
            pds.setVisible(true);
            dimenzija = new Dimension();
            dimenzija.width = Integer.parseInt(pds.getTfDimenzijaX().getText());
            dimenzija.height = Integer.parseInt(pds.getTfDimenzijaY().getText());
        }
        return dn;
    }
    public Dimension getDimenzijaSobe(){
        return dimenzija;
    }
}

