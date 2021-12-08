package com.issuetracker.controller.web;


import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.get;
import static org.hamcrest.Matchers.hasItem;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebAssigneeControllerIntegrationTest {
    @LocalServerPort
    public int port;

    @BeforeEach
    void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void 담당자_조회_요청() {
        get("/api/web/assignees")
                .then()
                .statusCode(200);
    }

    //TODO. init.sql에 정의된 더미 데이터를 기반으로 한 쉽게 깨질 테스트 케이스, JPA 마이그레이션 후 제거 예정
    @Test
    void 더미_담당자_목록중_sanhee가_존재한다() {
        get("/api/web/assignees")
                .then()
                .log().ifValidationFails()
                .assertThat().body("assinees.id", hasItem("sanhee"));
    }
}
