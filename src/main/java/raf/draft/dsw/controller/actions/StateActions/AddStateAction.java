package raf.draft.dsw.controller.actions.StateActions;

import com.sun.tools.javac.Main;
import raf.draft.dsw.controller.actions.AbstractRoomAction;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.NoviObjekatProzor;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.roomobjects.RoomElement;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.tabbedpane.TabbedPaneImplementation;
import raf.draft.dsw.tabbedpane.view.RoomView;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.time.LocalDateTime;

public class AddStateAction extends AbstractRoomAction {
    public AddStateAction(){
        putValue(SMALL_ICON, loadIcon("/images/add.png"));
        putValue(NAME, "Add");
        putValue(SHORT_DESCRIPTION, "Add");
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView rv = ((RoomView) ((TabbedPaneImplementation) MainFrame.getInstanca().getDesniPanel().getTabbedPane()).getTabbedPaneView().getSelectedComponent());

        if(rv == null){
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Nije otvoren prikaz sobe."));
            return;
        }
        if(rv.getOkvirSobe().getShape() == null)
        {
            Message messsage = new Message(MessageType.GRESKA, LocalDateTime.now(),"nije nadjen okvir sobe u koju se dodaje");
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(messsage);
            return;
        }
        MainFrame.getInstanca().getDesniPanel().startAddState();
        NoviObjekatProzor prozor = new NoviObjekatProzor();
        prozor.setVisible(true);
        String odabraniElement = prozor.getOdabrani();
        Dimension odabranaDimenzija = prozor.getDimension();
        if(odabraniElement == null){
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Nije odabrana vrsta elementa"));
            return;
        }
        if(odabranaDimenzija == null){
            ApplicationFramework.getInstanca().getMessageGenerator().generateMessage(new Message(MessageType.GRESKA,LocalDateTime.now(),"Nije odabrana dimenzija elementa"));
            return;
        }
        System.out.println(odabraniElement);
        MainFrame.getInstanca().getDesniPanel().setElementToAdd(odabraniElement);
        MainFrame.getInstanca().getDesniPanel().setDimensionToAdd(odabranaDimenzija);
    }
}
