package com.weatherapi.stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GetCityWeatherStepDefinition {

    @When("I send a Get request to the endpoint {string} with parameter {string} and value {string}")
    public void iSendAGetRequestToTheEndpointWithParameterAndValue(String endpoint, String param, String value) {

    }

    @Then("I validate the response code is {string} and the structure {string} is valid")
    public void iValidateTheResponseCodeIsAndTheStructureIsValid(String statusCode, String keys) {

    }
}
