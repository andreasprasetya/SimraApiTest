package com.juaracoding.apitest.definitions;

import io.cucumber.java.en.Given;

public class APIBackgroundTest {
    @Given("Preparing header for authorization")
    public void prepareHeader() {
        System.out.println("APIBackgroundTest::prepareHeader()");
    }
}
