package raf.draft.dsw.controller.actions;

import lombok.Data;

@Data
public class ActionManager {
    private ExitAction exitAction;
    private ONama oNama;
    private NewProjectAction newProjectAction;
    public ActionManager(){
        exitAction = new ExitAction();
        oNama = new ONama();
        newProjectAction = new NewProjectAction();
    }

}
