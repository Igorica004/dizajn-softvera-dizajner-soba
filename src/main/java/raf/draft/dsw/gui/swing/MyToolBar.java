package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ExitAction;
import raf.draft.dsw.controller.actions.NoviProjekatFormaAkcija;
import raf.draft.dsw.controller.actions.ONamaAkcija;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(){
        super(HORIZONTAL);
        setFloatable(false);

        ExitAction ea = MainFrame.getInstanca().getActionManager().getExitAction();
        ONamaAkcija on = MainFrame.getInstanca().getActionManager().getONamaAkcija();
        NoviProjekatFormaAkcija npa = MainFrame.getInstanca().getActionManager().getNoviProjekatFormaAkcija();
        add(on);
        add(ea);
        add(npa);
    }
}
