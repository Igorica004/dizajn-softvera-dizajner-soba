package raf.draft.dsw.controller.actions;

import lombok.Data;

@Data
public class ActionManager {
    private ExitAction exitAction;
    private ONama oNama;
    public ActionManager(){
        exitAction = new ExitAction();
        oNama = new ONama();
    }

}
