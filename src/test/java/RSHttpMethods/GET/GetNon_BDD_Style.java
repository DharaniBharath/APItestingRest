package RSHttpMethods.GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class GetNon_BDD_Style {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    String pincode="110048";

    @Test
    public void GetPOsitiveTest() {
        // DIVIDE YOUR PROGRAM INTO 3 PARTS
        // GIVEN - PART 1
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/" + pincode);


        //  When - Part 2
        response = r.when().log().all().get();
        System.out.println(response.asString());


        // Then - Part 3 - validation
        vr = response.then().log().all();
        vr.statusCode(200);


    }
}
