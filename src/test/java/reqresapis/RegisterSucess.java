package reqresapis;

import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import pojo.CreateUser;
import static io.restassured.RestAssured.*;

@Test
public class RegisterSucess {
    public static void main(String[] args) {
        RegisterSucess.registerSuccessful();
        RegisterSucess.registerUnsuccessful();
        RegisterSucess.loginSuccessful();
        RegisterSucess.loginUnsuccessful();
        RegisterSucess.delayedResponse();
    }

    public static void registerSuccessful() {
        given().spec(Utility.requestBuild()).body(Payload.register())
        .when().post("/api/register")
        .then().spec(Utility.responseBuild()).assertThat()
        .body("id", equalTo(4)).extract().response().asString();
    }

    public static void registerUnsuccessful() {
        given().spec(Utility.requestBuild()).body(Payload.registerUnsuccess())
        .when().post("/api/register")
        .then().assertThat().statusCode(400).body("error", equalTo("Missing password"))
        .extract().response().asString();
    }

    public static void loginSuccessful() {
        given().spec(Utility.requestBuild()).body(Payload.loginSuccess())
        .when().post("/api/login")
        .then().spec(Utility.responseBuild()).assertThat()
        .body("token", equalTo("QpwL5tke4Pnpja7X4")).extract().response().asString();
    }

    public static void loginUnsuccessful() {
        given().spec(Utility.requestBuild()).body(Payload.unsuccessfulLogin())
        .when().post("/api/login")
        .then().assertThat().statusCode(400).body("error", equalTo("Missing password"))
        .extract().response().asString();
    }

    public static void delayedResponse() {
        CreateUser response = given().spec(Utility.requestBuild()).queryParam("delayed", "3")
                .when().get("/api/users").as(CreateUser.class);
        System.out.println(response.getPage());
    }
}
