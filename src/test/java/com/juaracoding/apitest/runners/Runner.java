package com.juaracoding.apitest.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "@Registration", features = {
        "src/test/resources/features/01_Auth.feature"
},
        plugin = { "pretty:target/pretty.txt",
                "html:target/cucumber-reports/index.html",
                "json:target/cucumber-reports/index.json" },
        glue = "com.juaracoding.apitest.definitions")
public class Runner extends AbstractTestNGCucumberTests {

}
