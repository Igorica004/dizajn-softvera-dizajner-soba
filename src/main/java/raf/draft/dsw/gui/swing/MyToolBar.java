package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.ExitAction;
import raf.draft.dsw.controller.ONama;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(){
        super(HORIZONTAL);
        setFloatable(false);

        ExitAction ea = new ExitAction();
        ONama on = new ONama();
        add(on);
        add(ea);
    }
}
