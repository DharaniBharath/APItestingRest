package com.bharath;

import io.restassured.RestAssured;

public class Helloworld {

    public static void main(String[] args) {

        //bharath


        RestAssured
                .given().baseUri("https://google.com").log().all()
                .when().get()
                .then().statusCode(200).log().all();
    }
}




