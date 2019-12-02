package com.googledrive.files;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestAssureBasics {

    @Test
    public void uploadAFile () {
        given().baseUri("https://www.googleapis.com")
                .queryParam("uploadType", "media")
                .header("Authorization", "abc")
                .header("ContentType", "application/json")
                .body("{'a':'abc'}")
                .post("upload/drive/v3/files");

    }
}
