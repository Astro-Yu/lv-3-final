package com.mytest.mytest.comment;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class CommentControllerTest {

    @LocalServerPort
    private int port;


    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Commit
    @Test
    void 코멘트생성하면알림전송() {
        // given

        // when
        RestAssured.given().log().all()
                .contentType(ContentType.JSON)
                .when().post("/comments")
                .then().log().all()
                .statusCode(200);

        // then
    }
}
