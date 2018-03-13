package mballenegaleanotests.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import mballenegaleanotests.steps.serenity.EndUserSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;

public class LookUpAStationSteps {

    String station_name;

    @Steps
    EndUserSteps endUser;

    @Given("I want to know the street of $station_name station and nearby landmarks")
    public void givenIWantToKnowTheStreetOfAnyStationAndNearByLandmarks(String station_name ) {
        this.station_name = station_name;
    }

    @When("I insert $station_name as the query in API")
    public void whenIInsertStationNameAsTheQueryInAPI(){

    }

    @When("the user looks up the definition of the word '$word'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        endUser.looks_for(word);
    }

    @Then("they should see the definition '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        endUser.should_see_definition(definition);
    }






}
