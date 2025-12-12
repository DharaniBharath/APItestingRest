package RSHttpMethods.Post;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class Post_Non_BDD_Style {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;


    @Test
    public void test_POST_AUTH_TOKEN(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        r= RestAssured.given();
                r.baseUri("https://restful-booker.herokuapp.com");
                r.basePath("/auth");
                r.contentType(ContentType.JSON);
                r.log().all();
                r.body(payload);

        response = r.when().log().all().post();

        vr=response.then().log().all();
        vr.statusCode(200);

    }

}
