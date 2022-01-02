package io.cucumber.skeleton;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    private final String name;
    private ArrayList<String> messagesHeard = new ArrayList<>();
    private HashMap<Person, Integer> peopleInRange = new HashMap<>();
    private Integer MAX_HEARING_DISTANCE = 100;
    private Integer location = 0;

    public Person(String name) {
        this.name = name;
    }

    public void moveTo(Integer location) {
        this.location = location;
    }

    public void shout(String msg) {
        for (var person : peopleInRange.keySet()) {
            if (person.InRange(location)) {
                person.Hear(msg);
            }
        }
    }

    private void Hear(String msg) {
        messagesHeard.add(msg);
    }

    private boolean InRange(Integer locationOfShoutingSound) {
        var distance = this.location - locationOfShoutingSound;
        return distance <= MAX_HEARING_DISTANCE;
    }

    public ArrayList<String> getMessagesHeard() {
        return messagesHeard;
    }

    public void addInRangePeople(Person person, Integer distance) {
        peopleInRange.putIfAbsent(person, distance);
    }
}
