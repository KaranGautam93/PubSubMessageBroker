import Broker.Publisher;
import Broker.Subscriber;
import Broker.ThreadedMessageSend;
import Broker.Topic;

public class Main {
    public static void main(String[] args) {
        Topic topic1 = new Topic("topic 1");
        Topic topic2 = new Topic("topic 2");

        Subscriber subscriber1 = new Subscriber(1, "sub 1");
        Subscriber subscriber2 = new Subscriber(2, "sub 2");
        Subscriber subscriber3 = new Subscriber(3, "sub 3");
        Subscriber subscriber4 = new Subscriber(4, "sub 4");
        Subscriber subscriber5 = new Subscriber(5, "sub 5");

        topic1.subscribe(subscriber1);
        topic1.subscribe(subscriber2);
        topic1.subscribe(subscriber3);
        topic1.subscribe(subscriber4);
        topic1.subscribe(subscriber5);

        topic2.subscribe(subscriber1);
        topic2.subscribe(subscriber3);
        topic2.subscribe(subscriber4);


        Publisher publisher1 = new Publisher(1, "pub 1");
        Publisher publisher2 = new Publisher(2, "pub 2");

        Thread message1 = new ThreadedMessageSend(topic1, publisher1, "Message 1");
        message1.start();

        Thread message2 = new ThreadedMessageSend(topic1, publisher1, "Message 2");
        message2.start();

        Thread message3 = new ThreadedMessageSend(topic1, publisher1, "Message 3");
        message3.start();

        Thread message4 = new ThreadedMessageSend(topic2, publisher2, "Message 4");
        message4.start();

        Thread message5 = new ThreadedMessageSend(topic2, publisher2, "Message 5");
        message5.start();
    }
}
