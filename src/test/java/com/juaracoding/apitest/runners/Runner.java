package com.juaracoding.apitest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "not (@Web or (@Mobile and @SmokeTest) or @NewFeature)",
        features = {        "src/test/resources/features",
        }, glue = {
        "com.juaracoding.apitest.hooks",
        "com.juaracoding.apitest.definitions"
})
public class Runner extends AbstractTestNGCucumberTests {

}
