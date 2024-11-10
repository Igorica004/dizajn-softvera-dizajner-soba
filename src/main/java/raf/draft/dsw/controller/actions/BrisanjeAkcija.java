package raf.draft.dsw.controller.actions;

import com.sun.tools.javac.Main;
import raf.draft.dsw.gui.swing.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class BrisanjeAkcija extends AbstractRoomAction
{
    public BrisanjeAkcija(){
        //bitno
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_F4, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/exit.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete selected Node");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstanca().getDraftTree().removeChild();
    }
}
