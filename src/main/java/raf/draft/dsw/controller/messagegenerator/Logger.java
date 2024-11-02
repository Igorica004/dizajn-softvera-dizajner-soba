package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.model.messages.Message;

import java.io.IOException;

public interface Logger extends ISubscriber {
    void log(Notification notification) throws IOException;
    //Message poruka = new Message();
}
