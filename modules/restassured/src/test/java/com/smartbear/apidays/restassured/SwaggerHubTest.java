package com.smartbear.apidays.restassured;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
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

    @Test
    public void getFirstFoundApi() throws Exception {
        Response response = given().
            param("query", "testserver").
            when().
            get("https://api.swaggerhub.com/apis").
            then().
            contentType(ContentType.JSON).
            body("totalCount", equalTo(4)).
            extract().response();

        String url = response.path("apis[0].properties[0].url");

        given().
            get(url).
            then().
            contentType(ContentType.JSON).
            body("info.title", equalTo("TestServer"));
    }


}
