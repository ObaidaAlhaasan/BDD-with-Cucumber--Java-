package io.cucumber.skeleton;

import java.util.ArrayList;

public class Person {
    private final String name;
    private ArrayList<String> messagesHeard = new ArrayList<>();
    public Integer location = 0;
    private Network network;

    public Person(String name) {

        this.name = name;
    }
    public Person(String name, int location) {
        this.name = name;
        this.location = location;
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

    public boolean InRange(Integer locationOfShoutingSound, int range) {
        int distance = this.location - locationOfShoutingSound;
        return distance <= range;
    }

    public ArrayList<String> getMessagesHeard() {
        return messagesHeard;
    }
}
