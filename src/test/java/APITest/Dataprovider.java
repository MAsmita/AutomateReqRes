package APITest;
import static io.restassured.RestAssured.given;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;

public class Dataprovider {

@Test(dataProvider = "registerdetails")
public void user_registration(String name, String job) {

	RestAssured.baseURI = "https://reqres.in";
		given().header("Content-Type","application/json")
		.body(Payload.create_multiple_user1(name, job)).log().all()
		.when().post("/api/users")
		.then().assertThat().statusCode(201).extract().response().asString();
 }

@DataProvider(name = "registerdetails")
public Object[][] getdata() {
	return new Object[][] {{"michel","technician"},{"sofia","teamleader"},
				          {"adam","supervisor"}};
 }
}
