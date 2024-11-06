package raf.draft.dsw.controller.actions;

import lombok.Data;

@Data
public class ActionManager {
    private ExitAction exitAction;
    private ONamaAkcija oNamaAkcija;
    private NoviProjekatFormaAkcija noviProjekatFormaAkcija;
    public ActionManager(){
        exitAction = new ExitAction();
        oNamaAkcija = new ONamaAkcija();
        noviProjekatFormaAkcija = new NoviProjekatFormaAkcija();
    }

}
