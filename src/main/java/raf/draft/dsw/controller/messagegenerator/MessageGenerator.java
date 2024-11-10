package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.observer.Notification;
import raf.draft.dsw.model.messages.Message;

import java.util.ArrayList;

public class MessageGenerator implements IPublisher {
    private ArrayList<ISubscriber> subscriberList = new ArrayList<>();
    @Override
    public void addSubscriber(ISubscriber sub) {
        subscriberList.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscriberList.remove(sub);
    }

    public void generateMessage(Message m){
        notifySubscribers(new Notification(m));
    }
    @Override
    public void notifySubscribers(Notification notification) {
        for(ISubscriber subscriber : subscriberList) {
            subscriber.update(notification);
        }
    }
}
