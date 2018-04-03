
package mballenegaleanotests.steps;

import com.jayway.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import static io.restassured.http.ContentType.*;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.*;

public class OldDisruptionSteps extends Steps{


    @Given("I want to know the streets that were disrupted between $start_date and $end_date")
    public void givenIWantToKnowTheStreetsThatWereDisruptedOnADate(String start_date, String end_date) {
        this.requestSpecification = SerenityRest.given()
                .param("startDate", start_date)
                .param("endDate", end_date)
                .param("app_key", this.app_key)
                .param("app_id", this.app_id);    }


    @When("I send the request to the API with the dates")
    public void whenIInsertTheDatesInAPI(){
        this.response = requestSpecification.when().get("https://api.tfl.gov.uk/Road/all/Street/Disruption");
    }

    @Then("I should get the name of the street disrupted on that date")
    public void thenIShouldGetTheStreetNameInTheResponseBody(){
        this.response.then()
                .contentType(String.valueOf(JSON))
                .statusCode(200)
                .body("[0].streetName", greaterThanOrEqualTo(""));
    }


}
