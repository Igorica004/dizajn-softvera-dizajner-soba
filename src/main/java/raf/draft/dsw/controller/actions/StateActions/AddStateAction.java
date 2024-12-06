package raf.draft.dsw.controller.actions.StateActions;

import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.NoviObjekatProzor;

import java.awt.event.ActionEvent;

public class AddStateAction extends AbstractRoomAction {
    public AddStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/add.png"));
        putValue(NAME, "Add");
        putValue(SHORT_DESCRIPTION, "Add");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstanca().getDesniPanel().startAddState();
        NoviObjekatProzor prozor = new NoviObjekatProzor();
        prozor.setVisible(true);
    }
}
