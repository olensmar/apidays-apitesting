package com.smartbear.apidays.generated;

import com.smartbear.readyapi.client.api.APIsApi;
import com.smartbear.readyapi.client.model.ApisJson;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SwaggerHubTest {

    @Test
    public void testApiCount() throws Exception {
        APIsApi api = new APIsApi();
        ApisJson result = api.searchApis("testserver", null, null, null, null, null, null);
        assertEquals(new Long(4), result.getTotalCount());
    }
}
