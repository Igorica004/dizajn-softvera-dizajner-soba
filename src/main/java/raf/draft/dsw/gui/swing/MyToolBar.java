package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.*;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(){
        super(HORIZONTAL);
        setFloatable(false);

        ExitAction ea = MainFrame.getInstanca().getActionManager().getExitAction();
        ONamaAkcija on = MainFrame.getInstanca().getActionManager().getONamaAkcija();
        NoviCvorAkcija nca = MainFrame.getInstanca().getActionManager().getNoviCvorAkcija();
        add(on);
        add(ea);
        add(nca);
    }
}
