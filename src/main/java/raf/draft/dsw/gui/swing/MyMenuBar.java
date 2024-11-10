package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.BrisanjeAkcija;
import raf.draft.dsw.controller.actions.ExitAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea = new ExitAction();
        BrisanjeAkcija ba = new BrisanjeAkcija();
        fileMenu.add(ea);
        fileMenu.add(ba);
        add(fileMenu);
    }
}
