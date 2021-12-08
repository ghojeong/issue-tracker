package com.issuetracker.controller.web;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.get;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebLabelControllerIntegrationTest {
    @LocalServerPort
    public int port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost/api/web/labels";
        RestAssured.port = port;
    }

    @Test
    void 라벨을_조회하면_상태코드_200() {
        get()
                .then()
                .assertThat()
                .log().ifValidationFails()
                .statusCode(200);
    }
}
