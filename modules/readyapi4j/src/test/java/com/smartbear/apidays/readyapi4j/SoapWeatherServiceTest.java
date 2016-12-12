package com.smartbear.apidays.readyapi4j;

import org.junit.Test;

import java.net.URL;

import static com.smartbear.readyapi.client.execution.ExecutionUtils.executeRecipe;
import static com.smartbear.readyapi.client.teststeps.TestSteps.soapRequest;

public class SoapWeatherServiceTest {

    @Test
    public void simpleSoapTest() throws Exception {
        executeRecipe(
            soapRequest(new URL("http://www.webservicex.com/globalweather.asmx?WSDL"))
                .forBinding("GlobalWeatherSoap12")
                .forOperation("GetWeather")
                .withParameter("CountryName", "Sweden")
                .withPathParameter("//*:CityName", "Stockholm")
                .assertSoapOkResponse()
                .assertSchemaCompliance()
                .assertXPath("count(//*:GetWeatherResult)", "1")
        );
    }
}
