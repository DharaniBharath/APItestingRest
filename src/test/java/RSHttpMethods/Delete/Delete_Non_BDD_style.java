package RSHttpMethods.Delete;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Delete_Non_BDD_style {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;



@Test
    public void delete_positive_Tc(){

    String token = "d25771eb59edb6a";

    String bookingid = "2980";



    r = given();
    r.baseUri("https://restful-booker.herokuapp.com");
    r.basePath("/booking/" + bookingid);
    r.contentType("application/json");
    r.cookie("token", token);
//        r.auth().digest()
    // r.auth().basic()
    r.log().all();


    response = r.when().log().all().delete();


    vr = response.then().log().all();
    vr.statusCode(200);





}

}
