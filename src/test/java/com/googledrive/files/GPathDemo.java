package com.googledrive.files;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class GPathDemo extends APIBase {
    private String fileID ="1w2hCPxOvjjhxaNNQWvBcXQ6_Kxenyyby";

    @Test
    public void find () {
        Response response = getRequest().get("/drive/v3/files");
        response.body().path("findAll {it.files.name=='myPdfFile.pdf'}").toString();


    }
}
