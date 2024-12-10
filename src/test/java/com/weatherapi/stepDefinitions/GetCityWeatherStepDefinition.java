package com.weatherapi.stepDefinitions;

import com.weatherapi.tasks.GetCityWeatherTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.weatherapi.constants.Constants.BASE_URL;

public class GetCityWeatherStepDefinition {

    public static final String restAPI_URL = BASE_URL;

    @When("I send a Get request to the endpoint {string} with city name {string}")
    public void iSendAGetRequestToTheEndpointWithCityName(String endpoint, String cityName) {
        Actor user = Actor.named("user").whoCan(CallAnApi.at(restAPI_URL));

        user.attemptsTo(
                GetCityWeatherTask.withCityName(endpoint, cityName)
        );
    }

    @Then("I validate the response code is {string} and the structure {string} is valid")
    public void iValidateTheResponseCodeIsAndTheStructureIsValid(String statusCode, String keys) {

    }

    /**
     *     @Then("I Validate that the response code is {string}")
     *     public void iValidateThatTheResponseCodeIs(String code) {
     *
     *         Actor user = Actor.named("user");
     *
     *         String codeRest = String.valueOf(SerenityRest.lastResponse().getStatusCode());
     *         user.should(
     *                 seeThat("The responde code is",res->codeRest,equalTo(code))
     *         );
     *     }
     */
}
