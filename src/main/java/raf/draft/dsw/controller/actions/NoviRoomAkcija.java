package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ProzorNoviBuildingRoom;
import raf.draft.dsw.gui.swing.ProzorNoviRoom;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Room;

public class NoviRoomAkcija {
    public Room getRoom(){
        ProzorNoviRoom prozorNoviRoom = new ProzorNoviRoom("Make");
        prozorNoviRoom.setVisible(true);
        return prozorNoviRoom.getRoom();
    }
}
