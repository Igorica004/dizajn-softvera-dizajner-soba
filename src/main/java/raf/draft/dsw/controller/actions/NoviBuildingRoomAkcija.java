package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ProzorNoviBuildingRoom;
import raf.draft.dsw.model.nodes.DraftNode;

public class NoviBuildingRoomAkcija {
    public DraftNode getDraftNode(){
        ProzorNoviBuildingRoom prozorNoviBuildingRoom = new ProzorNoviBuildingRoom();
        prozorNoviBuildingRoom.setVisible(true);
        return prozorNoviBuildingRoom.getDraftNode();

    }
}

