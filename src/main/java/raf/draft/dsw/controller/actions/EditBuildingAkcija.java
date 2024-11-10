package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ProzorNoviBuildingRoom;

import javax.swing.*;

public class EditBuildingAkcija {
    public void setBuilding()
    {
        ProzorNoviBuildingRoom prozor = new ProzorNoviBuildingRoom("Edit");
        prozor.setVisible(true);
        prozor.setBuilding();
    }
}
