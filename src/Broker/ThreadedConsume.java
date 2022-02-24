package Broker;

public class ThreadedConsume extends Thread {

    private Subscriber subscriber;

    private String message;

    public ThreadedConsume(Subscriber subscriber, String message) {
        this.subscriber = subscriber;
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (subscriber) {
            try {
                Thread.currentThread().sleep(1000);
                subscriber.printMessage(message);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
