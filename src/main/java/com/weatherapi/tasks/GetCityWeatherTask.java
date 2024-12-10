package com.weatherapi.tasks;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.rest.interactions.Get;

import static net.serenitybdd.screenplay.Tasks.instrumented;

@AllArgsConstructor
public class GetCityWeatherTask implements Task {

    public final String endpoint;
    public final String cityName;

    @Override
    public <T extends Actor> void performAs(T actor) {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.config = RestAssured.config().redirect(RestAssured.config().getRedirectConfig().followRedirects(true));

        actor.attemptsTo(
                Get.resource(endpoint)
                        .with(requestSpecification -> requestSpecification
                                .contentType(ContentType.JSON)
                                .queryParam("name", cityName) // Agregamos el parámetro "name"
                                .log()
                                .all()
                        )
        );

    }

    public static Performable withCityName(String endpoint, String cityName) {
        return instrumented(GetCityWeatherTask.class, endpoint, cityName);
    }
}
