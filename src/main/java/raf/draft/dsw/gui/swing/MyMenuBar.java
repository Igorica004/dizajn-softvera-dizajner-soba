package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.*;
import raf.draft.dsw.serializer.actions.OpenProjectAkcija;
import raf.draft.dsw.serializer.actions.SaveAkcija;
import raf.draft.dsw.serializer.actions.SaveAsAkcija;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea = new ExitAction();
        BrisanjeAkcija ba = new BrisanjeAkcija();
        EditCvorAkcija eca = new EditCvorAkcija();
        SaveAkcija sa = new SaveAkcija();
        SaveAsAkcija saa = new SaveAsAkcija();
        OpenProjectAkcija opa = new OpenProjectAkcija();
        fileMenu.add(ea);
        fileMenu.add(ba);
        fileMenu.add(eca);
        fileMenu.add(sa);
        fileMenu.add(saa);
        fileMenu.add(opa);
        add(fileMenu);
    }
}
