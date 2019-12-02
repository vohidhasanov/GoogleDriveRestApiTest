package com.googledrive.files;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.client.methods.RequestBuilder;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class OpenWeatherAPIBase extends APIBase {

    private String fileIDToRename = "1w2hCPxOvjjhxaNNQWvBcXQ6_Kxenyyby";

  protected RequestSpecification getRequest () {
        RequestSpecification req = new RequestSpecBuilder()
                .setBaseUri("http://api.openweathermap.org")
                .addQueryParam("appid", "0ed51b9aff84fdc1fbae693bcad77df1").build();
                return given(req).log().all();
    }
}
