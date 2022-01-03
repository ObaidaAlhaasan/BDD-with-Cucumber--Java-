package io.cucumber.skeleton;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Network {
    public static final Pattern BUY_PATTERN = Pattern.compile("buy", Pattern.CASE_INSENSITIVE);

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

    public void broadcast(String message, Person shouter) {
        int shouterLocation = shouter.location;
        boolean shortEnough = (message.length() <= 180);
        deductCredits(shortEnough, message, shouter);
        for (Person listener : listeners) {
            if (listener.InRange(shouterLocation, this.range) && shortEnough) {
                listener.Hear(message);
            }
        }
    }

    private void deductCredits(boolean shortEnough, String message, Person shouter) {
        if (!shortEnough) {
            shouter.setCredits(shouter.getCredits() - 2);
        }
        Matcher matcher = BUY_PATTERN.matcher(message);
        while (matcher.find()) {
            shouter.setCredits(shouter.getCredits() - 5);
        }
    }
}
