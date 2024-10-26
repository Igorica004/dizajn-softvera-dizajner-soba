package raf.draft.dsw.controller.messagegenerator;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;

public class MessageGenerator implements IPublisher {
    @Override
    public void addSubscriber(ISubscriber sub) {
        subscriberList.add(sub);
    }

    @Override
    public void removeSubscriber(ISubscriber sub) {
        subscriberList.remove(sub);
    }

    @Override
    public void notifySubscribers(Object notification) {
        for(ISubscriber subscriber : subscriberList) {
            subscriber.update(notification);
        }
    }
}
