package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.BrisanjeAkcija;
import raf.draft.dsw.controller.actions.EditCvorAkcija;
import raf.draft.dsw.controller.actions.ExitAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea = new ExitAction();
        BrisanjeAkcija ba = new BrisanjeAkcija();
        EditCvorAkcija eca = new EditCvorAkcija();
        fileMenu.add(ea);
        fileMenu.add(ba);
        fileMenu.add(eca);
        add(fileMenu);
    }
}
