package com.juaracoding.apitest;

import org.hamcrest.CoreMatchers;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AppTest {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;

    @Test
    public void stepTest01() {
        RequestSpecification requestSpecification;
        Response response;
        ValidatableResponse validatableResponse;

        RestAssured.baseURI = "http://localhost:8000";

        RestAssured.given().header("Authorization", "Token e15f90cdb341ec965f4203fc25cdc71d2d6392db")  .get("/catalogs/groups/")
                .then().statusCode(200).statusLine("HTTP/1.1 200 OK").body("count", CoreMatchers.instanceOf(Integer.class));

//        requestSpecification.header("Authorization", "Token e15f90cdb341ec965f4203fc25cdc71d2d6392db");
//        response = requestSpecification.get("/catalogs/groups/");
//        String statusLine = response.statusLine();
//        int statusCode = response.statusCode();
//        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
//        Assert.assertEquals(statusCode, 200);

    }
}
