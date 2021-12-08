package com.issuetracker.controller.web;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebMilestoneControllerIntegrationTest {
    @LocalServerPort
    public int port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost/api/web/milestones";
        RestAssured.port = port;
    }

    @Test
    void 마일스톤_조회할_떄_상태코드_200() {
        RestAssured.get()
                .then()
                .statusCode(200);
    }
}
