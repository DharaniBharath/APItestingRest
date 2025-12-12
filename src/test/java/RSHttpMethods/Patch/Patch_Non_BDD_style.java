package RSHttpMethods.Patch;

import com.github.javafaker.Faker;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Patch_Non_BDD_style {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;



@Test
    public void patch_positive_Tc(){

    String token = "d25771eb59edb6a";

    String bookingid = "2980";

    // Faker lib

    Faker faker = new Faker();

    String name = faker.name().fullName();
    System.out.println(name);

    String payload = "{\n" +
            "    \"firstname\" : \""+name+"\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"additionalneeds\" : \"Breakfast\"\n" +
            "}";


    r = given();
    r.baseUri("https://restful-booker.herokuapp.com");
    r.basePath("/booking/" + bookingid);
    r.contentType("application/json");
    r.cookie("token", token);
//        r.auth().digest()
    // r.auth().basic()
    r.body(payload).log().all();


    response = r.when().log().all().patch();


    vr = response.then().log().all();
    vr.statusCode(200);





}

}
