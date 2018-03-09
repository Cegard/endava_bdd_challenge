package mballenegaleanobdd.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

import mballenegaleanobdd.steps.serenity.EndUserSteps;

public class StationSteps {

    @Steps
    EndUserSteps endUser;
/*
    @Given("I want to add $number1 and $number2 numbers")
    public void givenIWantToAddTwoNumbers(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    @When("I use the calculator for adding these number")
    public void iUseTheCalculatorForAddingTheseNumber() {
        this.result = number1 + number2;
    }

    @Then("I should see $expectedResult as the result")
    public void IShouldSeeTheCorrectResult(int expectedResult) {
        assertThat(this.result,is(expectedResult));
    }*/

    @Given("I want to know the street of $stationName station and nearby landmarks")
    public void givenIWantToKnowTheStreetOfAStationAndNearbyLandmarks(String stationName){
        //Todo
    }



}
