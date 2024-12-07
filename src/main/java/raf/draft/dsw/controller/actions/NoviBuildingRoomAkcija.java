package raf.draft.dsw.controller.actions;

import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.ProzorDimenzijeSobe;
import raf.draft.dsw.gui.swing.ProzorNoviBuildingRoom;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Room;

import java.awt.*;
import java.time.LocalDateTime;

public class NoviBuildingRoomAkcija {
    Dimension dimenzija = null;
    public DraftNode getDraftNode(){
        ProzorNoviBuildingRoom prozorNoviBuildingRoom = new ProzorNoviBuildingRoom("Make");
        prozorNoviBuildingRoom.setVisible(true);
        DraftNode dn = prozorNoviBuildingRoom.getDraftNode();
        if(dn instanceof Room){
            ProzorDimenzijeSobe pds = new ProzorDimenzijeSobe();
            pds.setVisible(true);
            try{
                dimenzija = new Dimension();
                dimenzija.width = Integer.parseInt(pds.getTfDimenzijaX().getText());
                dimenzija.height = Integer.parseInt(pds.getTfDimenzijaY().getText());
            } catch(Exception e){
                dimenzija = null;
                ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Nisu dobre dimenzije sobe"));
                return null;
            }
        }
        return dn;
    }
    public Dimension getDimenzijaSobe(){
        return dimenzija;
    }
}

