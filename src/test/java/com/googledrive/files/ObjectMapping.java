package com.googledrive.files;

import com.sun.jnlp.ApiDialog;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class ObjectMapping extends OpenWeatherAPIBase {
    //private String fileIDToRename = "1w2hCPxOvjjhxaNNQWvBcXQ6_Kxenyyby";

    @Test
    public void  createAnAlertWithJsonAsString() {
        String alertJson = "{\"time_period\":{\"start\":{\"expression\":\"after\",\"amount\":132000000},\"end\":{\"expression\":\"after\",\"amount\":432000000}},\"conditions\":[{\"name\":\"temp\",\"expression\":\"$gt\",\"amount\":299}],\"area\":[{\"type\":\"Point\",\"coordinates\":[53,37]}]}";
        Response response = getRequest().header("Content-Type", "application/json").body(alertJson).post("data/3.0/triggers");
        System.err.println(response.getStatusCode());
        System.out.println("The response is: " +response.asString());
    }



        @Test
        public void  createAnAlertWithJavaObject() {
        WeatherAlert weatherAlert = new WeatherAlert();
        Time_period time_period = new Time_period();

        Start start = new Start();
        start.setAmount(132000000);
        start.setExpression("after");

        End end = new End();
        end.setAmount(432000000);
        end.setExpression("after");

        time_period.setStart(start);
        time_period.setEnd(end);
            weatherAlert.setTime_period(time_period);


            Response response = getRequest().header("Content-Type", "application/json").body(weatherAlert).post("data/3.0/triggers");
            System.err.println(response.getStatusCode());
            System.out.println("The response is: " +response.asString());
        }
//    @Test
//    public void renameAFile () {
//        Response response = getRequest().body("{\"name\":\"myNewTextFile.txt\"}").patch("/drive/v3/files/"+fileIDToRename);
//        System.out.println(response.asString());
//    }

}
