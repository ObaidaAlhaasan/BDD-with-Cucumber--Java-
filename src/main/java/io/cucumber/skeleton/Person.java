package io.cucumber.skeleton;

import java.util.ArrayList;
import java.util.HashMap;

public class Person {
    private ArrayList<String> messagesHeard = new ArrayList<>();
    private HashMap<Person, Integer> peopleInRange = new HashMap<>();
    private Integer position;

    Person(Integer position){
        this.position = position;
    }
    public void moveTo(Integer distance) {
    }

    public void shout(String msg) {
        peopleInRange.forEach((person, distance) -> {
            if (person.InRange(distance)){
                person.Hear(msg);
            }
        });
    }

    private void Hear(String msg) {
        messagesHeard.add(msg);
    }

    private boolean InRange(Integer distance) {
        return  distance <= position;
    }

    public ArrayList<String> getMessagesHeard() {
        return messagesHeard;
    }

    public void addInRangePeople(Person person, Integer distance) {
        peopleInRange.putIfAbsent(person, distance);
    }
}
