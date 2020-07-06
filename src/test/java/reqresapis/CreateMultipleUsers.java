package reqresapis;

import static io.restassured.RestAssured.given;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pojo.CreateDetails;
import pojo.ResponseUpdateJob;
import pojo.UserDetails;

public class CreateMultipleUsers {

    @Test(dataProvider = "registerdetails")
    public void user_Registration(UserDetails user) {

        given().spec(Utility.requestBuild()).body(user)
        .when().post("/api/users")
        .then().log().all().assertThat().statusCode(201)
        .extract().response().asString();
    }

    @DataProvider(name = "registerdetails")
    public Object[][] getData() {
        return new Object[][] { { new UserDetails("michel", "technician") },
                { new UserDetails("sofia", "developer") } };
    }

    @Test
    public static void update_Job_Info() {
        CreateDetails cp = new CreateDetails();
        cp.setName("morpheus");
        cp.setJob("zion resident");
        cp.setEmail("morp.zion@reqres.in");
        cp.setId(7);

        ResponseUpdateJob resp = given().spec(Utility.requestBuild())
                .queryParam("page", "2").body(cp)
                .when().put("/api/users/2").as(ResponseUpdateJob.class);

        System.out.println("Updated Job: " + resp.getJob());
        System.out.println("Updated Email: " + resp.getEmail());
    }
}
