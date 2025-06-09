package com.juaracoding.apitest.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class RegistrationTest {

    @Given("User is on the registration page")
    public void step01() {
        System.out.println("RegistrationTest:step01");
    }

    @When("User enters valid registration details")
    public void step02() {
        System.out.println("RegistrationTest:step02");
    }

    @And("User submits the registration form")
    public void step03() {
        System.out.println("RegistrationTest:step03");
    }

    @Then("User should see a success message")
    public void step04() {
    }
}
