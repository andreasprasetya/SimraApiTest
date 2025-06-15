package com.juaracoding.apitest.definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LogOut {
    WebDriver driver;

    @Given("User is on the signin page")
    public void step01() {
        System.out.println("SignInTest::step01");
    }

    @And("User clicks the logout menu")
    public void step03() {
        WebElement logoutButton = driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[2]/div[1]/nav[1]/a[3]"));
        System.out.println("SignInTest::step02");
    }

    @Then("User should be redirected to the homepage")
    public void step04() {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("signing"));
        System.out.println("SignInTest::step03");
    }

}
