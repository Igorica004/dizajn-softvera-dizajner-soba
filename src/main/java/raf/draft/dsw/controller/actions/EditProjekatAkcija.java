package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ProzorNoviProjekat;

public class EditProjekatAkcija {
    public void setProjekat(){
        ProzorNoviProjekat prozor = new ProzorNoviProjekat("Edit");
        prozor.setVisible(true);
        prozor.setProject();
    }
}
