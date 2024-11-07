package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ProzorNoviProjekatForma;
import raf.draft.dsw.model.structures.Project;

import java.awt.event.ActionEvent;


public class NoviProjekatAkcija {

    public Project getProject(){
        ProzorNoviProjekatForma prozorNoviProjekatForma = new ProzorNoviProjekatForma();
        prozorNoviProjekatForma.setVisible(true);
        return prozorNoviProjekatForma.getProject();
    }
}
