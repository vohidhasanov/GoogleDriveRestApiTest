package com.googledrive.files;
import com.fasterxml.jackson.databind.util.JSONPObject;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class FileTestCases extends APIBase {

    @Test (enabled=true)
    public void getAllFiles_GPATH_Demo () {
        //Construct request
        Response response =  getRequest().get("/drive/v3/files");
        //System.out.println(response.asString());
        //String fID = response.body().path("files.find{it.name=='myPdfFile.pdf'}.id"); // for first match
        //List <String> fID = response.body().path("files.findAll{it.name=='myPdfFile.pdf'}.id"); // for more elements
        List <String> fID = response.body().path("files.findAll{it.kind=='drive#file'}.id"); // for more elements
        for (String s : fID) {
            System.err.println(s);
        }
      //  System.err.println(fID);


    }

    @Test
    public void deleteAllFiles () {
        Response response = getRequest().get("/drive/v3/files/");
        System.err.println(response.asString());
        List <String> fileIDs = response.path("files.id");


        for (String list : fileIDs) {
            System.out.println(list);
        }
          //System.out.println(obj);
    }


    @Test
    public void getSingleFile () {
        Response response = getRequest().get("/drive/v3/files/1w2hCPxOvjjhxaNNQWvBcXQ6_Kxenyyby");
      // Assert.assertEquals(response.path("name"), "fileToTestComment.pdf");
    }

    @DataProvider (name = "getFilesData")
    public Object[][] getTestFiles () {
       return new String [][]
       {
        {"C:\\Users\\Vohid-PC\\Desktop\\Postman\\google drive demo\\shablonMetaData.json", "C:\\Users\\Vohid-PC\\Desktop\\Postman\\google drive demo\\shablon.pdf", "application/pdf"},
        {"C:\\Users\\Vohid-PC\\Desktop\\Postman\\google drive demo\\VohidTextFileMetaData.json","C:\\Users\\Vohid-PC\\Desktop\\Postman\\google drive demo\\VohidTextFile.txt", "text/plain"},
        {"C:\\Users\\Vohid-PC\\Desktop\\Postman\\google drive demo\\VohidPngFileMetaData.json", "C:\\Users\\Vohid-PC\\Desktop\\Postman\\google drive demo\\VohidPngImage.png","image/png"}
       };
    }


    @Test (dataProvider = "getFilesData")
    public void uploadFileWithMetaData(String metaDataFile , String fileToUpload, String fileMimeType) {

        File metaData = new File(metaDataFile);
        File pdfFile = new File (fileToUpload);
        String filename = fileToUpload.split("\\\\")[6];
       System.out.println(filename);

       Response response = getRequest()
                .header("Content-Type", "multipart/form-data")
                .multiPart("", metaData,"application/json")
                .multiPart("", fileToUpload, fileMimeType)

            .post("upload/drive/v3/files");

        System.err.println(response.asString());

        String id = response.path("id");
        String name = response.path("name");
        String mimeType = response.path("mimeType");

        Assert.assertEquals(name, filename);
        Assert.assertNotNull(id);
        Assert.assertEquals(mimeType, fileMimeType);

        //clean after verification
        response = getRequest().delete("drive/v3/files/"+id);
        System.out.println(response.getStatusCode());

    }


    @Test
    public void getAllFiles ()  {
        //Construct request
        String responseAsString = getRequest()
                .get("/drive/v3/files")
                .body().asString();
        System.err.println(responseAsString);
    }

    @Test
    public void deleteFile ()  {
        //Construct request
        int responseStatusCode  = getRequest()
                .delete("/drive/v3/files/1Y3VeMGcHFXfAS19mG9jKOWwXOTrVYeh2")
                .statusCode();
        System.err.println(responseStatusCode);
    }

    @Test
    public void getAllFiles_veryfiy_status_code ()  {
        //Construct request
       getRequest()
                .get("/drive/v3/files")
               .body().path("");


    }

    @Test
    public void getAllFiles_veryfiy_has_JSON_data ()  {
        //Construct request
        getRequest()
                .get("/drive/v3/files")
                .then().body("files[0].name", hasItems("Untitled","Getting started"));
    }

   public void getSingleFile (String fileID) {

        Response responce = getRequest().get("/drive/v3/files/"+fileID);
        System.out.println("File ID retrieved: "+responce);
        //Assert.assertEquals(responce.path("name"), "file");
   }


    @Test
    public void getAllFiles_get_file_and_then_get_first_file ()  {
        //Construct request

                String fileId = getRequest().get("/drive/v3/files").body().path("files[0].id");
                String name = getRequest().get("/drive/v3/files").body().path("files[0].name");
        System.out.println("Retrieving file "+name+", id: "+fileId);

        getSingleFile(fileId);
    }

}
