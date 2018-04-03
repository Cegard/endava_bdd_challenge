package mballenegaleanotests.steps;

import com.jayway.restassured.response.Response;
import net.serenitybdd.rest.decorators.request.RequestSpecificationDecorated;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import net.serenitybdd.rest.SerenityRest;

import static io.restassured.http.ContentType.HTML;
import static io.restassured.http.ContentType.JSON;
import static io.restassured.http.ContentType.TEXT;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThan;


public class DisruptionSteps extends Steps{

    @Step
    @Given("I want to know there is a disruption given A406, A2")
    public void givenIWantToKnowThereAreDisruptedStreetsRightNow() {
        this.requestSpecification = SerenityRest.given()
                .param("stripContent", "true")
                .param("app_key", this.app_key)
                .param("app_id", this.app_id);
        this.requestSpecification.header("content-type", "application/json; charset=utf-8");
    }

    @Step
    @When("I send the request to the API with the parameter")
    public void ISendTheRequestToTheAPIWithNoDates(){
        this.response = requestSpecification.when().get("https://api.tfl.gov.uk/Road/A406, A2/Disruption");
    }

    @Step
    @Then("I should get $location_name where is disrupted")
    public void IShouldGetANotNullStreetNameInTheResponse(String location_name){
        this.response.then()
                .contentType(String.valueOf(JSON))
                .statusCode(200)
                .body("[0].location", equalTo(location_name));
    }


}
