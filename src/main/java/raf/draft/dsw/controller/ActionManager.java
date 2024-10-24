package raf.draft.dsw.controller;

import lombok.Data;

import java.awt.desktop.AboutEvent;

@Data
public class ActionManager {
    private ExitAction exitAction;
    private ONama oNama;
    public ActionManager(){
        exitAction = new ExitAction();
        oNama = new ONama();
    }

}
