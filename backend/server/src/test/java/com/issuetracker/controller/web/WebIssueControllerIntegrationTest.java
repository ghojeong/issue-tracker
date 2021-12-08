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

    //TODO. 쿼리파라미터 필터로 이슈 조회하는 테스트도 추후 작성 해야함.

    //TODO. 배포 환경에서는 99999999번째 이슈가 있을 수도 있다. 상수를 안쓰는 방법을 찾아보자.
    @Test
    void 존재하지_않는_이슈_상세_정보_조회() {
        get("/99999999")
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    void 이슈_생성시_사이드_옵션을_조회_할때_상태코드_200(){
        get("/form")
                .then()
                .assertThat()
                .statusCode(200);
    }
}
