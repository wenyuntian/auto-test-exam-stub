package com.thoughtworks.exam;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;

public abstract class TestBase {

    @BeforeEach
    public void setup() {
        RestAssured.baseURI = "http://localhost:8000";
    }

}