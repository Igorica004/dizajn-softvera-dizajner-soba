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
        KopiranjeElementaAkcija kea = MainFrame.getInstanca().getActionManager().getKopiranjeElementaAkcija();
        PasteElementaAkcija pea = MainFrame.getInstanca().getActionManager().getPasteElementaAkcija();
        add(on);
        add(ea);
        add(nca);
        add(kea);
        add(pea);
    }
}
