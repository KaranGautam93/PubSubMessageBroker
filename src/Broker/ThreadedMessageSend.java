package Broker;

public class ThreadedMessageSend extends Thread {
    private Topic topic;
    private Publisher publisher;
    private String message;

    public ThreadedMessageSend(Topic topic, Publisher publisher, String message) {
        this.topic = topic;
        this.publisher = publisher;
        this.message = message;
    }

    @Override
    public void run() {
        try {
            Thread.currentThread().sleep(1000);
            synchronized (publisher) {
                publisher.produce(message, topic);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
