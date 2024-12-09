package com.weatherapi.runners;

import com.weatherapi.utils.BeforeSuite;
import com.weatherapi.utils.DataToFeature;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

import java.io.IOException;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.weatherapi.stepDefinitions",
        tags = "@GetWeather",
        snippets = CucumberOptions.SnippetType.CAMELCASE
)
@RunWith(PersonalizedRunner.class)
public class GetCityWeatherRunner {

    @BeforeSuite
    public static void test() throws InvalidFormatException, IOException {
        DataToFeature.overrideFeatureFiles(".src/test/resources/features/getCityWeather.feature");
    }
}