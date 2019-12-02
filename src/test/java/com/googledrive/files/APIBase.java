package com.googledrive.files;
import io.restassured.RestAssured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;

public class APIBase {
    protected RequestSpecification request;

//    public APIBase() {
//        request = given()
//                .baseUri("https://www.googleapis.com")
//                .header("Authorization", "Bearer"+
//                        "ya29.Il-vB0zaykgsbEilkTTj6oo56V2s_R7nY90G8iGnHjhhX7fcx2ZqIYxG_Je3wfjk9sNZqqnqopM2hjhM0Q8M_ZBKvqoOPBEXmeAVi70VTfeJpkLK-ljCgD9sEYgDSoHg7g");
//    }

    protected RequestSpecification getRequest () {
        RequestSpecification req = new RequestSpecBuilder().setBaseUri("https://www.googleapis.com")
                .addHeader("Authorization", "Bearer " +
                  "ya29.Il-wB2RdH1WPWlV12fuo7zYBADNSKPoXUnn9PBo3qFrTqAC6twxR4flKKm0ssYxSlYv9LMBQEIXcJQH_cZF_hbKynty2HmTc25WQXH2pmAXMA6EVUXbMKyEgmbc8hnKkgg")
                .build();
        return given(req).log().all();
    }
}
