package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.Notification;

import raf.draft.dsw.model.messages.Message;

public class ConsoleLogger implements Logger {

    @Override
    public void log(Notification notification) {
        System.out.println(notification.getPoruka());
    }

    @Override
    public void update(Notification notification) {
        log(notification);
    }



}
