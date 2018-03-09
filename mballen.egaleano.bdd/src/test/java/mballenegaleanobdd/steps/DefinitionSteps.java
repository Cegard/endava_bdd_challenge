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

public class DefinitionSteps {

    int number1 = 0;
    int number2 = 0;
    int result = 0;

    @Steps
    EndUserSteps endUser;

    @Given("the user is on the Wikionary home page")
    public void givenTheUserIsOnTheWikionaryHomePage() {
        endUser.is_the_home_page();
    }

    @When("the user looks up the definition of the word '$word'")
    public void whenTheUserLooksUpTheDefinitionOf(String word) {
        endUser.looks_for(word);
    }

    @Then("they should see the definition '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        endUser.should_see_definition(definition);
    }

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
    }
}
