package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ProzorNoviBuildingRoom;
import raf.draft.dsw.gui.swing.ProzorNoviRoom;

public class EditRoomAkcija {
    public void setRoom()
    {
        ProzorNoviRoom prozor = new ProzorNoviRoom("Edit");
        prozor.setVisible(true);
        prozor.setRoom();
    }
}
