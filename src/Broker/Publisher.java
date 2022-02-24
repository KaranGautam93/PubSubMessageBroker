package Broker;

public class Publisher {
    private int id;
    private String name;

    public Publisher(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void produce(String message, Topic topic) {
        topic.send(message);
    }
}
