package Broker;

public class Subscriber {
    private int id;
    private String name;

    public Subscriber(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void printMessage(String message) {
        System.out.println(this.name + " received message " + message);
    }

    public String getName() {
        return name;
    }
}
