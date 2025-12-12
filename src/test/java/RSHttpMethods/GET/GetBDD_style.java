package RSHttpMethods.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class GetBDD_style {

    @Test
    public void test_Get_positive(){

        String pincode="110048";

        RestAssured.given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pincode)


                .when().get()


                .then().log().all()
                .statusCode(200);

    }

}
