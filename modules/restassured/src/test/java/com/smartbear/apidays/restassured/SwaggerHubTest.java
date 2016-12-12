package com.smartbear.apidays.restassured;

import io.restassured.http.ContentType;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SwaggerHubTest {

    @Test
    public void testApiCount() throws Exception {
        given().
            param("query", "testserver").
            when().
            get("https://api.swaggerhub.com/apis").
            then().
            contentType(ContentType.JSON).
            body("totalCount", equalTo(4));
    }
}
