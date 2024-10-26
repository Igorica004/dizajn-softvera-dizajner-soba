package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ExitAction;
import raf.draft.dsw.controller.actions.ONama;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(){
        super(HORIZONTAL);
        setFloatable(false);

        ExitAction ea = MainFrame.getInstanca().getActionManager().getExitAction();
        ONama on = MainFrame.getInstanca().getActionManager().getONama();
        add(on);
        add(ea);
    }
}
