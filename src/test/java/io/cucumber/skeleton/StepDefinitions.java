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

    @Given("Lucy is {int} metres from Sean")
    public void lucy_is_metres_from_Sean(Integer distance) {
        lucy = new Person(distance);
        sean = new Person(0);
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
}