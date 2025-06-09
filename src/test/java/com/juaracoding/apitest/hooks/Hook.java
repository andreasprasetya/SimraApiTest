package com.juaracoding.apitest.hooks;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hook {

    @BeforeAll
    public static void initialize() {
        System.out.println("before all jalan");
    }

    @AfterAll
    public static void finalTeardown() {
        System.out.println("after all jalan");

    }

}