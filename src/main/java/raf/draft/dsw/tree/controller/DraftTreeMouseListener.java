package raf.draft.dsw.tree.controller;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.tree.DraftTreeImplementation;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;

public class DraftTreeMouseListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent e) {
        DraftNode selektovani = MainFrame.getInstanca().getDraftTree().getSelectedNode().getDraftNode();
        if (e.getClickCount() == 2 && selektovani instanceof Project){
            DraftTreeImplementation stablo = (DraftTreeImplementation)MainFrame.getInstanca().getDraftTree();
            stablo.setSelektovaniProjekat(selektovani);
            stablo.notifySubscribers(new Notification(new Message(null,null,"selekcijaProjekta")));
        }
    }
}
