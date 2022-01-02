package io.cucumber.skeleton;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.List;

public class StepDefinitions {

    private Person lucy;
    private Person sean;
    private String msgFromSean;
    private Person mike;

    @Given("Lucy is standing/located {int} metre(s) from Sean")
    public void lucy_is_metres_from_Sean(Integer distance) {
        lucy = new Person();
        sean = new Person();
        lucy.moveTo(distance);
        sean.addInRangePeople(lucy, distance);
    }

    @When("Sean shouts {string}")
    public void sean_shouts(String msg) {
        msgFromSean = msg;
        sean.shout(msgFromSean);
    }

    @Then("Lucy should hear Sean's message")
    public void lucy_should_hear_Sean_s_message() {
        Assert.assertEquals(List.of(msgFromSean), lucy.getMessagesHeard());
    }

    @Given("Mike is standing/located {int} metres from Sean")
    public void mike_is_metres_from_sean(Integer distance) {
        mike = new Person();
        sean = new Person();
        mike.moveTo(distance);
        sean.addInRangePeople(mike, distance);
    }

    @Then("Mike shouldn't hear Sean's message")
    public void mike_shouldn_t_hear_sean_s_message() {
      Assert.assertNotEquals(List.of(msgFromSean), mike.getMessagesHeard());
    }
}