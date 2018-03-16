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
import static org.hamcrest.Matchers.greaterThan;


public class LookUpAStationSteps {

    String app_key = "9c91a07926c0b50e203764c21b312247";
    String app_id = "6325577f";
    com.jayway.restassured.specification.RequestSpecification requestSpecification;
    Response response;


    @Step
    @Given("I want to know the street of $station_name station and nearby landmarks")
    public void givenIWantToKnowTheStreetOfAnyStationAndNearByLandmarks(String station_name ) {
        requestSpecification = SerenityRest.given()
                .param("query", station_name)
                .param("app_key", this.app_key)
                .param("app_id", this.app_id);
    }

    @Step
    @When("I insert $station_name as the query in API")
    public void whenIInsertStationNameAsTheQueryInAPI(){
        response = requestSpecification.when().get("https://api.tfl.gov.uk/BikePoint/Search");
    }

    @Step
    @Then("I should get $street_name inside Json object response")
    public void whenTheUserLooksUpTheDefinitionOf() {
        response.then()
                .contentType(String.valueOf(JSON))
                .statusCode(200)
                .body("[0].commonName", containsString(((RequestSpecificationDecorated) requestSpecification).getRequestParams().get("query").toString()));
    }


    @Step
    @Given("I want to know the state of $station_name and its occupancy")
    public void IWantToKnowTheStateOfAStationAndItsOccupancy(String station_code){
        requestSpecification = SerenityRest.given()
                .param("app_key", this.app_key)
                .param("app_id", this.app_id);
    }

    @Step
    @When("I request API for the state of $station_id")
    public void whenIRequestAPIForTheStateOfTheStation(String station_id){
        response = requestSpecification.when().get("https://api.tfl.gov.uk/BikePoint/"+station_id);
    }

    @Step
    @Then("I should get station status and its occupancy")
    public void IShouldGetStationStatusAndItsOccupancy() {

        //int hey =  Integer.parseInt(response.body("additionalProperties[6].value"));
        response.then()
                .contentType(String.valueOf(JSON))
                .statusCode(200)
                .body("additionalProperties[6].value", greaterThan("0"));
    }


}
