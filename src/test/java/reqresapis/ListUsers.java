package reqresapis;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;
import pojo.ResponseSingleUser;

@Test
public class ListUsers {

    public static void main(String[] args) {
        ListUsers.deleteUser();
        ListUsers.listSingleUser();
        ListUsers.singleResourceNotfound();
        ListUsers.listResources();
        ListUsers.listSingleResources();
        ListUsers.singleUserNotfound();
    }

    public static void deleteUser() {
        given().spec(Utility.requestBuild())
        .when().delete("/api/users/4")
        .then().assertThat().statusLine(containsString("204 No Content"));
    }

    public static void listSingleUser() {
        ResponseSingleUser resp = given().spec(Utility.requestBuild())
                .when().get("/api/users/7").as(ResponseSingleUser.class);
        System.out.println(resp.getAd().getUrl());
    }

    public static void singleUserNotfound() {
        given().spec(Utility.requestBuild())
        .when().get("/api/users/23")
        .then().assertThat().statusCode(404).statusLine(containsString("404 Not Found"));
    }

    public static void listResources() {
        given().spec(Utility.requestBuild())
        .when().get("/api/unknown")
        .then().spec(Utility.responseBuild()).body("per_page", equalTo(6));
    }

    public static void listSingleResources() {
        given().spec(Utility.requestBuild())
        .when().get("/api/unknown/2")
        .then().spec(Utility.responseBuild());
    }

    public static void singleResourceNotfound() {
        given().spec(Utility.requestBuild())
        .when().get("/api/unknown/22")
        .then().assertThat().statusCode(404);
    }
}
