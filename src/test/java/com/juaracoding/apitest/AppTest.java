package com.juaracoding.apitest;

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
        RestAssured.baseURI = "http://localhost:8000";

        requestSpecification = RestAssured.given();
        requestSpecification.header("Authorization", "Token e15f90cdb341ec965f4203fc25cdc71d2d6392db");
        response = requestSpecification.get("/catalogs/groups/");
        validatableResponse = response.then();
        validatableResponse.statusCode(200);
        validatableResponse.statusLine("HTTP/1.1 200 OK");
    }
}
