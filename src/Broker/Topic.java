package Broker;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Topic {
    private String name;

    private List subscribers;

    public Topic(String name) {
        this.name = name;
        subscribers = new ArrayList<Subscriber>();
    }

    public String getName() {
        return name;
    }

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void send(String message) {
        Iterator<Subscriber> it = subscribers.iterator();

        while (it.hasNext()) {
            Subscriber subscriber = it.next();
            ThreadedConsume threadedConsume = new ThreadedConsume(subscriber, message);
            threadedConsume.start();
        }
    }
}
