package com.googledrive.files;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class JsonSchemaValidation extends APIBase {
    private String fileID ="1w2hCPxOvjjhxaNNQWvBcXQ6_Kxenyyby";

    @Test
    public void verifyFileRespondAgainstSchema () {
        Response response = getRequest().get("/drive/v3/files/"+fileID);
        System.out.println(response.asString());
        response.then().assertThat().body(matchesJsonSchema(new File("C:\\Users\\Vohid-PC\\IdeaProjects\\GoogleDriveRestApiTest\\src\\main\\resources\\GoogleDriveJsonSchema.json")));

    }


}
