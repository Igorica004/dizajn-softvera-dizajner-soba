package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.ExitAction;
import raf.draft.dsw.controller.ONama;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(MainFrame mainFrame){
        super(HORIZONTAL);
        setFloatable(false);

        ExitAction ea = mainFrame.getActionManager().getExitAction();
        ONama on = mainFrame.getActionManager().getONama();
        add(on);
        add(ea);
    }
}
