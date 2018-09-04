package patterndemos.observer;

import java.util.ArrayList;

public class EmitterDog {
    private ArrayList<SubscriberOwner> subscribers = new ArrayList<>();

    public void subscribe(SubscriberOwner owner) {
        this.subscribers.add(owner);
    }

    public void bark() {
        for (SubscriberOwner o : this.subscribers) {
            o.update();
        }
    }
}
