package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ProzorNoviProjekat;
import raf.draft.dsw.model.structures.Project;


public class NoviProjekatAkcija {

    public Project getProject(){
        ProzorNoviProjekat prozorNoviProjekat = new ProzorNoviProjekat("Make");
        prozorNoviProjekat.setVisible(true);
        return prozorNoviProjekat.getProject();
    }
}
