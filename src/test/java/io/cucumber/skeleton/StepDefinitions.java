package io.cucumber.skeleton;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;

public class StepDefinitions {

    private Person sean = new Person("Sean");
    private Person rangePerson;
    private String msgFromSean;
    private Network network;
    private HashMap<String, Person> persons;

    @Before
    public void createNetwork() {
        network = new Network();
        persons = new HashMap<>();
    }

    @Given("{person} is standing/located {int} metre(s) from Sean")
    public void lucy_is_metres_from_Sean(Person person, Integer distance) {
        rangePerson = person;
        rangePerson.moveTo(distance);
        sean.setNetwork(network);
        rangePerson.setNetwork(network);
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String msg) {
        msgFromSean = msg;
        sean.shout(msgFromSean);
    }

    @Then("Lucy should hear Sean's message")
    public void lucy_should_hear_Sean_s_message() {
        Assert.assertEquals(List.of(msgFromSean), rangePerson.getMessagesHeard());
    }

    @Then("Mike shouldn't hear Sean's message")
    public void mike_shouldn_t_hear_sean_s_message() {
        Assert.assertNotEquals(List.of(msgFromSean), rangePerson.getMessagesHeard());
    }

    @Given("a person named {word}")
    public void aPersonNamedLucy(String word) {
        persons.put(word, new Person(word));
    }
}