package com.issuetracker.controller.web;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebIssueControllerIntegrationTest {
    @LocalServerPort
    public int port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost/api/web/issues";
        RestAssured.port = port;
    }

    @Test
    void 전체_이슈_조회() {
        get()
                .then()
                .log().ifValidationFails()
                .statusCode(200);
    }
}
