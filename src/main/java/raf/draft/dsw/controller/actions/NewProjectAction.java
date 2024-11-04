package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.tree.model.DraftTreeItem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class NewProjectAction extends AbstractRoomAction{

    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(
                KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/newproject.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }
//javlja NullPointerException jer pokusava da getuje Children array listu iz ProjectExplorer koji jos ne postoji
//mozda izmeniti getter ProjectExplorer da ako lista ne postoji da je napravi?
//idk boli me mozak pisem ovo jer znam da cu zaboraviti
    @Override
    public void actionPerformed(ActionEvent e) {
        DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstanca().getDraftTree().getSelectedNode();
        MainFrame.getInstanca().getDraftTree().addChild(selected);
    }
}
