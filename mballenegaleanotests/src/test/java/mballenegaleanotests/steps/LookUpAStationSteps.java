package mballenegaleanotests.steps;

import com.jayway.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.decorators.request.RequestSpecificationDecorated;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import mballenegaleanotests.steps.serenity.EndUserSteps;

import net.serenitybdd.rest.SerenityRest;
import static io.restassured.http.ContentType.JSON;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

import  java.util.List;

public class LookUpAStationSteps {

    String app_key = "9c91a07926c0b50e203764c21b312247";
    String app_id = "6325577f";
    com.jayway.restassured.specification.RequestSpecification requestSpecification;
    Response response;

    List<String> street_name;

    @Steps
    EndUserSteps endUser;

//
//    @Test
//    public void validationsInTheBodyResponse() {
//        Response response = given()
//                .param("query","bares de salsa en Cali")
//                .param("sensor","false")
//                .param("key", "AIzaSyC4Pwj-KCxYSpyBdzPyyjwnjYd7BuPNwZQ")
//                .when()
//                .get("https://maps.googleapis.com/maps/api/place/textsearch/json")
//                .then()
//                .contentType(JSON)
//                .statusCode(200)
//                .body("results[0].formatted_address", equalTo("Av 5 Norte #16 Norte4-6,Cali, Valle del Cauca, Colombia"))
//                .extract().response();
//        System.out.println(response.getBody().prettyPrint());
//    }

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
    @Then("I should get $street_name")
    public void whenTheUserLooksUpTheDefinitionOf(String street_name) {
        response.then()
                .contentType(String.valueOf(JSON))
                .statusCode(200)
                .body("[0].commonName", containsString(((RequestSpecificationDecorated) requestSpecification).getRequestParams().get("query").toString()+"ghjk"));
    }

    @Then("they should see the definition '$definition'")
    public void thenTheyShouldSeeADefinitionContainingTheWords(String definition) {
        endUser.should_see_definition(definition);
    }






}
