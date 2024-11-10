package raf.draft.dsw.controller.observer;

import java.util.ArrayList;
import java.util.Observer;

public interface IPublisher {
    void addSubscriber(ISubscriber sub);
    void removeSubscriber(ISubscriber sub);
    void notifySubscribers(Notification notification);
}
