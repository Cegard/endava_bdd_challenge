package mballenegaleanotests.steps;

import com.jayway.restassured.response.Response;
import net.serenitybdd.rest.decorators.request.RequestSpecificationDecorated;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.serenitybdd.rest.SerenityRest;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;


public class DisruptionSteps extends Steps {

    @Step
    @Given("I want to know the streets that were disrupted between $start_date and $end_date")
    public void givenIWantToKnowTheStreetsThatWereDisruptedOnADate(String start_date, String end_date) {
        requestSpecification = SerenityRest.given()
                .param("startDate", start_date)
                .param("endDate", end_date)
                .param("app_key", this.app_key)
                .param("app_id", this.app_id);
    }

    @Step
    @When("I send the request to the API")
    public void whenIInsertStationNameAsTheQueryInAPI(){
        response = requestSpecification.when().get("https://api.tfl.gov.uk/Road/all/Street/Disruption?");
    }

    @Step
    @Then("I should get $street_name in the response body")
    public void thenIShouldGetTheStreetNameInTheResponseBody(){
        response.then()
                .contentType(String.valueOf(JSON))
                .statusCode(200)
                .body("[0].streetName", equalTo("Queen Victoria Street (EC2R,EC3V)"));
    }
}
