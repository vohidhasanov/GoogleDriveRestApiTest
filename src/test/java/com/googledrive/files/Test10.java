package com.googledrive.files;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class Test10 {

   @Test
   public void Authentification() {
      RestAssured.baseURI = "http://restapi.demoqa.com/authentication";
      RequestSpecification request = RestAssured.given();

      Response response = request.get("/CheckForAuthentication");
      System.out.println("Status Code "+ response.getStatusCode());
      System.out.println("Status messege "+ response.body().asString());
   }


}
