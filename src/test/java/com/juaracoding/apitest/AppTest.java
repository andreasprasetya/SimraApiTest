package com.juaracoding.apitest;

import org.hamcrest.CoreMatchers;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class AppTest {
    RequestSpecification requestSpecification;
    Response response;
    ValidatableResponse validatableResponse;
    private int id;

    @BeforeClass
    public void setup() {
        RestAssured.baseURI = "http://localhost:8000";
    }

    @Test
    public void getListGroup() {
        requestSpecification = RestAssured.given();
        requestSpecification.header(
                "Authorization",
                "Token e15f90cdb341ec965f4203fc25cdc71d2d6392db");
        response = requestSpecification.get("/catalogs/groups/");

        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
        Assert.assertEquals(response.getStatusCode(), 200);

        System.out.println("Isi next" + response.jsonPath().getString("next"));
        String next = response.jsonPath().getString("next");
        int count = response.jsonPath().getInt("count");

        if (next != null) {
            Assert.assertNull(next);
        } else {
            Assert.assertNotNull(next);
        }

        Assert.assertNotNull(count);

        System.out.println(response.jsonPath().getInt("count"));

        RestAssured.given().header(
                        "Authorization",
                        "Token e15f90cdb341ec965f4203fc25cdc71d2d6392db")
                .get("/catalogs/groups/")
                .then()
                .statusCode(200)
                .statusLine("HTTP/1.1 200 OK")
                .body("count", CoreMatchers.instanceOf(Integer.class))
                .body("next", CoreMatchers.anyOf(CoreMatchers.nullValue(), CoreMatchers.instanceOf(Integer.class)));
    }

    @Test(dependsOnMethods = "getListGroup")
    public void createGroup() {
        JSONObject payload = new JSONObject();
        payload.put("title", "Mobil Dinas Java");
        payload.put("origin", "Pemkot DKI Javarta");

        Response response = RestAssured
                .given()
                .header(
                        "Authorization",
                        "Token e15f90cdb341ec965f4203fc25cdc71d2d6392db")
                .contentType(ContentType.JSON)
                .body(payload.toString())
                .when()
                .post("/catalogs/groups/");

        id = response.jsonPath().getInt("id");

        // validatableResponse = response.then();

        // // Get status code
        // validatableResponse.statusCode(200);

        // // Check status line is as expected
        // validatableResponse.statusLine("HTTP/1.1 200 OK");

    }

    @Test(dependsOnMethods = "createGroup")
    public void updateGroup() {
        JSONObject payload = new JSONObject();
        payload.put("title", "Truk Java");
        payload.put("origin", "Pemkot DKI Javarta");

        RestAssured
                .given()
                .header(
                        "Authorization",
                        "Token e15f90cdb341ec965f4203fc25cdc71d2d6392db")
                .contentType(ContentType.JSON)
                .body(payload.toString())
                .when()
                .put("/catalogs/groups/" + id + "/")
                .then()
                .log().all();
    }

    @Test(dependsOnMethods = "updateGroup", enabled = false)
    public void deleteGroup() {
        JSONObject payload = new JSONObject();
        payload.put("title", "Truk Java");
        payload.put("origin", "Pemkot DKI Javarta");

        RestAssured
                .given()
                .header(
                        "Authorization",
                        "Token e15f90cdb341ec965f4203fc25cdc71d2d6392db")
                .contentType(ContentType.JSON)
                .when()
                .delete("/catalogs/groups/" + id + "/")
                .then()
                .log().all();
    }
}
