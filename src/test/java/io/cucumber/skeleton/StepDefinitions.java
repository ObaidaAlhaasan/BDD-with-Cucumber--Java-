package io.cucumber.skeleton;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.Before;
import io.cucumber.java.DataTableType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.*;

public class StepDefinitions {

    private Person sean = new Person("Sean");
    private Person rangePerson;
    private String msgFromSean;
    private Network network;
    private HashMap<String, Person> people;

    public static class Whereabouts {
        public String name;
        public Integer location;

        public Whereabouts(String name, Integer locaiton) {
            this.name = name;
            this.location = locaiton;
        }
    }

    @DataTableType
    public Whereabouts defineWhereabouts(Map<String, String> entry) {
        return new Whereabouts(entry.get("name"), Integer.parseInt(entry.get("location")));
    }

    @Before
    public void createNetwork() {
        network = new Network();
        people = new HashMap<>();
        sean.setNetwork(network);
    }

    @Given("{person} is standing/located {int} metre(s) from Sean")
    public void lucy_is_metres_from_Sean(Person person, Integer distance) {
        rangePerson = person;
        rangePerson.moveTo(distance);
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
    public void aPersonNamed(String word) {
        Person person = new Person(word);
        person.setNetwork(network);
        people.put(word, person);
    }

    @Given("the range is {int}")
    public void the_range_is(Integer range) {
        network = new Network(range);
    }

    // option 1 simple DataTable
//    @Given("people are located at")
//    public void people_are_located_at(io.cucumber.datatable.DataTable dataTable) {
//        for (Map<String, String> map : dataTable.asMaps()) {
//            var person = new Person(map.get("name"));
//            person.setNetwork(network);
//            people.put(map.get("name"), person);
//        }
//    }


    // option 2
    @Given("people are located at")
    public void people_are_located_at(List<Whereabouts> whereaboutsList) {
        for (Whereabouts whereabouts : whereaboutsList) {
            var person = new Person(whereabouts.name);
            person.setNetwork(network);
            people.put(whereabouts.name, person);
        }
    }

    @When("Sean shouts")
    public void sean_shouts() {
        people.get("Sean").shout("Hello, world!");
    }

    @Then("Lucy should hear a shout")
    public void lucy_should_hear_a_shout() {
        Assert.assertEquals(1, people.get("Lucy").getMessagesHeard().size());
    }


    @Then("Lucy hears the following messages:")
    public void lucy_hears_the_following_messages(io.cucumber.datatable.DataTable expectedMsg) {
        List<List<String>> actualMessages = new ArrayList<List<String>>();
        List<String> heard = people.get("Lucy").getMessagesHeard();
        for (String message : heard) {
            actualMessages.add(Collections.singletonList(message));
        }

        expectedMsg.diff(DataTable.create(actualMessages));
    }

    @When("Sean shouts the following message")
    public void sean_shouts_the_following_message(String docString) {
        sean.shout(docString);
    }

    @Then("Lucy should not hear a shout")
    public void lucy_should_not_hear_a_shout() {
        Assert.assertEquals(0, people.get("Lucy").getMessagesHeard().size());
    }
}