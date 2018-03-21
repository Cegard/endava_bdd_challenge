package mballenegaleanotests.steps;

import com.jayway.restassured.response.Response;
import net.serenitybdd.rest.decorators.request.RequestSpecificationDecorated;
import net.thucydides.core.annotations.Step;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import net.serenitybdd.rest.SerenityRest;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThanOrEqualTo;


public class RouteTimesSteps {
    String app_key = "9c91a07926c0b50e203764c21b312247";
    String app_id = "6325577f";
    com.jayway.restassured.specification.RequestSpecification requestSpecification;
    Response response;


    @Step
    @Given("Given I am in $startingLocation")
    public void givenIKnowWhereImLocatedAndWhereImGoing(String startingLocation){
        this.requestSpecification = SerenityRest.given()
                .param("from", startingLocation)
                .param("app_key", this.app_key)
                .param("app_id", this.app_id);
    }


    @Step
    @Given("And I am going to $endingLocation")
    public void andGivenIAmGoingTO(String endingLocation){
        this.requestSpecification = SerenityRest.given()
                .param("to", endingLocation);
    }


    @Step
    @When("I ask for the route time")
    public void whenIAskForTheRoutTime(){
        this.response = requestSpecification.when().
                get("https://api.tfl.gov.uk/Journey/JourneyResults");
    }


    @Step
    @Then("The answer I get is $journeyTime minutes")
    public void IShouldGetATimeInMinutes(int journeyTime){
        this.response.then().
                contentType(String.valueOf(JSON)).
                statusCode(200).
                body("journeys[0]", equalTo(journeyTime));
    }


    @Step
    @Then("The answer I get is $journeyTime minutes And it can differ within $errorTime minutes")
    public void IShouldGetATimeInMinutesWithAnError(int journeyTime, int errorTime){
        this.response.then().
                contentType(String.valueOf(JSON)).
                statusCode(200).
                body("journeys[0]", greaterThanOrEqualTo(journeyTime - errorTime));
    }


    @Step
    @Then("The status code I get is $statusCode")
    public void IGetAStatusCode(int statusCode){
        this.response.then().
                contentType(String.valueOf(JSON)).
                statusCode(statusCode);
    }
}
