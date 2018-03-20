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


public class DisruptionSteps extends Steps {

    @Step
    @Given("I want to know the streets that were disrupted between $start_date and $end_date")
    public void givenIWantToKnowTheStreetsThatWereDisruptedOn18Mar2018(String start_date, String end_date) {
        requestSpecification = SerenityRest.given()
                .param("startDate", start_date)
                .param("endDate", end_date)
                .param("app_key", this.app_key)
                .param("app_id", this.app_id);
    }
}
