package io.cucumber.skeleton;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private final List<Person> listeners;
    private Integer range = 100;

    public Network() {
        listeners = new ArrayList<Person>();
    }

    public Network(Integer range) {
        listeners = new ArrayList<Person>();
        this.range = range;
    }

    public void subscribe(Person person) {
        listeners.add(person);
    }

    public void broadcast(String message, int location) {
        for (Person listener : listeners) {
            boolean shortEnough = message.length() <= 180;
            if (listener.InRange(location, this.range) && shortEnough) {
                listener.Hear(message);
            }
        }
    }
}