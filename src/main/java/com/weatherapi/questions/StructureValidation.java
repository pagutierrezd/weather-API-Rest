package com.weatherapi.questions;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import java.util.List;
import java.util.Map;

@AllArgsConstructor
public class StructureValidation implements Question<Boolean> {

    protected Response response;
    protected String keys;

    @Override
    public Boolean answeredBy(Actor actor) {
        JsonPath jsonPath = response.jsonPath();

        // Se accede al array "data" dentro de la respuesta
        List<Map<String, Object>> dataArray = jsonPath.getList("data");

        if (dataArray == null || dataArray.isEmpty()) {
            throw new AssertionError("The 'data' array is missing or empty in the response");
        }

        // Se valida las claves del primer objeto dentro del array "data"
        Map<String, Object> firstObject = dataArray.get(0);
        String[] keysArray = keys.split(",");

        for (String key : keysArray) {
            if (!firstObject.containsKey(key.trim())) {
                throw new AssertionError("The key '" + key + "' is not present in the first object of 'data'");
            }
        }

        return true;
    }

    public static StructureValidation matches(Response response, String keys) {
        return new StructureValidation(response, keys);
    }
}
