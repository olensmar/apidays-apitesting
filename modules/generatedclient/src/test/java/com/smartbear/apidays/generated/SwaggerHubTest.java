package com.smartbear.apidays.generated;

import com.smartbear.readyapi.client.api.APIsApi;
import com.smartbear.readyapi.client.model.ApisJson;
import com.smartbear.readyapi.client.model.ApisJsonApi;
import com.smartbear.readyapi.client.model.ApisJsonProperty;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwaggerHubTest {

    @Test
    public void testApiCount() throws Exception {
        APIsApi api = new APIsApi();
        ApisJson result = api.searchApis("testserver", null, null, null, null, null, null);
        assertEquals(new Long(4), result.getTotalCount());
    }

    @Test
    public void testGetFirstApi() throws Exception {
        APIsApi api = new APIsApi();
        ApisJson result = api.searchApis("testserver", null, null, null, null, null, null);
        assertEquals(new Long(4), result.getTotalCount());

        ApisJsonApi firstApi = result.getApis().get(0);
        ApisJsonProperty apisJsonProperty = firstApi.getProperties().get(0);
        assertEquals("Swagger", apisJsonProperty.getType());
    }
}
