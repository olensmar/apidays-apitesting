package com.smartbear.apidays.httpclient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.fluent.Request;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.assertEquals;

public class SwaggerHubTest {

    @Test
    public void testApiCount() throws Exception {
        InputStream input = Request.Get("https://api.swaggerhub.com/apis?query=testserver")
            .execute().returnContent().asStream();

        ObjectMapper m = new ObjectMapper();
        JsonNode rootNode = m.readTree( input );

        assertEquals( 4, rootNode.get("totalCount").asInt());
    }
}
