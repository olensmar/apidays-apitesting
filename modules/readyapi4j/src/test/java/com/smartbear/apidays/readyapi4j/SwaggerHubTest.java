package com.smartbear.apidays.readyapi4j;

import org.junit.Test;

import static com.smartbear.readyapi.client.assertions.Assertions.json;
import static com.smartbear.readyapi.client.execution.ExecutionUtils.executeRecipe;
import static com.smartbear.readyapi.client.teststeps.TestSteps.getRequest;
import static com.smartbear.readyapi.client.teststeps.TestSteps.propertyTransfer;
import static com.smartbear.readyapi.client.teststeps.propertytransfer.PropertyTransferBuilder.from;
import static com.smartbear.readyapi.client.teststeps.propertytransfer.PropertyTransferSourceBuilder.aSource;
import static com.smartbear.readyapi.client.teststeps.propertytransfer.PropertyTransferTargetBuilder.aTarget;
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

    @Test
    public void getFirstFoundApi() throws Exception {
        executeRecipe(
            getRequest("https://api.swaggerhub.com/apis")
                .named("Search")
                .withParameters(
                    query("query", "testserver")
                )
                .withAssertions(
                    json("$.totalCount", "4")
                ),
            propertyTransfer()
                .addTransfer(
                    from(aSource()
                        .withSourceStep("Search")
                        .withPath("$.apis[0].properties[0].url")
                    )
                        .to(aTarget()
                            .withTargetStep("getDefinition")
                            .withProperty("Endpoint")
                        )
                ),
            getRequest("https://api.swaggerhub.com")
                .named("getDefinition")
                .withAssertions(
                    json("$.info.title", "TestServer")
                )
        );
    }

}
