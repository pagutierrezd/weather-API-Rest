package com.weatherapi.stepDefinitions;

import com.weatherapi.questions.StructureValidation;
import com.weatherapi.tasks.GetCityWeatherTask;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.rest.abilities.CallAnApi;

import static com.weatherapi.constants.Constants.BASE_URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class GetCityWeatherStepDefinition {

    public static final String REST_API_URL = BASE_URL;

    @When("I send a Get request to the endpoint {string} with city name {string}")
    public void iSendAGetRequestToTheEndpointWithCityName(String endpoint, String cityName) {
        Actor user = Actor.named("user").whoCan(CallAnApi.at(REST_API_URL));

        user.attemptsTo(
                GetCityWeatherTask.withCityName(endpoint, cityName)
        );
    }

    @Then("I validate the response code is {string} and the structure {string} is valid")
    public void iValidateTheResponseCodeIsAndTheStructureIsValid(String statusCode, String keys) {
        Response responseAPI = SerenityRest.lastResponse();
        String statusCodeResponse = String.valueOf(responseAPI.getStatusCode());
        Actor user = Actor.named("user");

        user.should(
                seeThat("The response code is ", response -> statusCodeResponse.equals(statusCode)),
                seeThat("The structure is valid", StructureValidation.matches(responseAPI, keys))
        );
    }
}