package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.*;
import raf.draft.dsw.controller.actions.StateActions.EditElementStateAction;
import raf.draft.dsw.controller.actions.StateActions.ZoomStateAction;
import raf.draft.dsw.state.concrete.EditElementState;

import javax.swing.*;
import java.awt.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(){
        super(HORIZONTAL);
        setFloatable(false);
        ExitAction ea = MainFrame.getInstanca().getActionManager().getExitAction();
        ONamaAkcija on = MainFrame.getInstanca().getActionManager().getONamaAkcija();
        NoviCvorAkcija nca = MainFrame.getInstanca().getActionManager().getNoviCvorAkcija();
        KopiranjeElementaAkcija kea = MainFrame.getInstanca().getActionManager().getKopiranjeElementaAkcija();
        PasteElementaAkcija pea = MainFrame.getInstanca().getActionManager().getPasteElementaAkcija();
        EditElementStateAction eea = MainFrame.getInstanca().getActionManager().getEditElementStateAction();
        ZoomStateAction zsa = MainFrame.getInstanca().getActionManager().getZoomStateAction();
        UndoAction ua = MainFrame.getInstanca().getActionManager().getUndoAction();
        RedoAction ra = MainFrame.getInstanca().getActionManager().getRedoAction();
        OrganizeMyRoomAction omra= MainFrame.getInstanca().getActionManager().getOrganizeMyRoomAction();
        add(on);
        add(ea);
        add(nca);
        add(kea);
        add(pea);
        add(eea);
        add(zsa);
        add(ua);
        add(ra);
        add(omra);
    }
}
