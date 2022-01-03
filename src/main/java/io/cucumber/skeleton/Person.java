package io.cucumber.skeleton;

import java.util.ArrayList;

public class Person {
    private final String name;
    private ArrayList<String> messagesHeard = new ArrayList<>();
    private Integer MAX_HEARING_DISTANCE = 100;
    public Integer location = 0;
    private Network network;

    public Person(String name) {
        this.name = name;
    }

    public void moveTo(Integer location) {
        this.location = location;
    }

    public void setNetwork(Network network) {
        this.network = network;
        network.subscribe(this);
    }

    public void shout(String msg) {
        network.broadcast(msg, this.location);
    }

    public void Hear(String msg) {
        messagesHeard.add(msg);
    }

    public boolean InRange(Integer locationOfShoutingSound) {
        int distance = this.location - locationOfShoutingSound;
        return distance <= MAX_HEARING_DISTANCE;
    }

    public ArrayList<String> getMessagesHeard() {
        return messagesHeard;
    }
}
