package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.ProzorNoviProjekatForma;
import raf.draft.dsw.tree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class NoviProjekatFormaAkcija extends AbstractRoomAction{

    public NoviProjekatFormaAkcija() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/newproject.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstanca().getDraftTree().getSelectedNode();
        ProzorNoviProjekatForma forma = new ProzorNoviProjekatForma();
        forma.setVisible(true);
    }
}
