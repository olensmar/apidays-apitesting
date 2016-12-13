package com.smartbear.samples.cucumber.extension;

import com.smartbear.readyapi.testserver.cucumber.CucumberRecipeBuilder;
import com.smartbear.readyapi.testserver.cucumber.RestStepDefs;
import cucumber.api.java.en.Given;
import cucumber.runtime.java.guice.ScenarioScoped;

import javax.inject.Inject;

/**
 * Sample custom StepDef that adds an alternative way of specifying API endpoints
 */

@ScenarioScoped
public class CustomStepDefs {

    private final CucumberRecipeBuilder recipeBuilder;
    private final RestStepDefs restStepDefs;

    @Inject
    public CustomStepDefs(CucumberRecipeBuilder recipeBuilder, RestStepDefs restStepDefs) {
        this.recipeBuilder = recipeBuilder;
        this.restStepDefs = restStepDefs;
    }

    @Given("^an endpoint of (.*)$")
    public void anEndpointOf(String endpoint) throws Throwable {
        restStepDefs.setEndpoint(endpoint);
    }
}
