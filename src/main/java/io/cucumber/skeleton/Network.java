package io.cucumber.skeleton;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private final List<Person> listeners;

    public Network() {
        listeners = new ArrayList<Person>();
    }

    public void subscribe(Person person) {
        listeners.add(person);
    }

    public void broadcast(String message, int location) {
        for (Person listener : listeners) {
            if (listener.InRange(location)) {
                listener.Hear(message);
            }
        }
    }
}