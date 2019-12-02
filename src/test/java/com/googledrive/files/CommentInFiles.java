package com.googledrive.files;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CommentInFiles extends APIBase {

    @Test
    public void    createComment () {
        String json = "{\"content\": \" my first comment\"}";
        Response response = getRequest()
                .queryParam("fields", "*")
                .contentType(ContentType.JSON)
                .body (json)
                .post("drive/v3/files/1OYmWr1cQoTRE_yCjv1N0wAggGIdegLrF/comments");

   //     Response response1 = getRequest().post("/drive/v3/files/1OYmWr1cQoTRE_yCjv1N0wAggGIdegLrF/"+json);

        System.out.println(response.asString());
        Assert.assertEquals(response.path("content"), "my first comment");
        deleteComment("1OYmWr1cQoTRE_yCjv1N0wAggGIdegLrF", (String) response.path("id"));
    }

    @Test
    public void getCommentFromFile () {
        Response response = getRequest().queryParam("fields","*").get( "drive/v3/files/1OYmWr1cQoTRE_yCjv1N0wAggGIdegLrF/comments/AAAAD6pxz-M");

        System.out.println(response.asString());
    }

    @Test
    public void deleteComment (String fileID, String commentID) {
        Response response = getRequest().delete("drive/v3/files/"+fileID+"/comments/"+commentID);
        System.out.println(response.asString());
        Assert.assertEquals(response.getStatusCode(), 204);
    }
}
