package com.smartbear.apidays.readyapi4j;

import org.junit.Test;

import static com.smartbear.readyapi.client.assertions.Assertions.json;
import static com.smartbear.readyapi.client.execution.ExecutionUtils.executeRecipe;
import static com.smartbear.readyapi.client.teststeps.TestSteps.getRequest;
import static com.smartbear.readyapi.client.teststeps.restrequest.ParameterBuilder.query;

public class SwaggerHubTest {

    @Test
    public void simpleCountTest() throws Exception {

        executeRecipe(
            getRequest("https://api.swaggerhub.com/apis")
                .withParameters(
                    query("query", "testserver")
                )
                .withAssertions(
                    json("$.totalCount", "4")
                )
        );
    }


}
