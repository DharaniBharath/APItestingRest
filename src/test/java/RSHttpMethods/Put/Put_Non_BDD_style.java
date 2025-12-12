package RSHttpMethods.Put;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Put_Non_BDD_style {
    RequestSpecification r;
    Response response;
    ValidatableResponse vr;



@Test
    public void put_positive_Tc(){

    String token = "d25771eb59edb6a";

    String bookingid = "2980";

    // Faker lib

    Faker faker = new Faker();

    String name = faker.name().fullName();
    System.out.println(name);

    String payload = "{\n" +
            "    \"firstname\" : \""+name+"\",\n" +
            "    \"lastname\" : \"Brown\",\n" +
            "    \"totalprice\" : 111,\n" +
            "    \"depositpaid\" : true,\n" +
            "    \"bookingdates\" : {\n" +
            "        \"checkin\" : \"2018-01-01\",\n" +
            "        \"checkout\" : \"2019-01-01\"\n" +
            "    },\n" +
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


    response = r.when().log().all().put();


    vr = response.then().log().all();
    vr.statusCode(200);





}

}
