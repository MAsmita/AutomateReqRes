package APITest;
import static io.restassured.RestAssured.given;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import pojo.CreatePost2;

public class Dataprovider2 {
	
@Test(dataProvider = "registerdetails")
public void user_registration(CreatePost2 createpost) 
 { 
	RestAssured.baseURI = "https://reqres.in";
	  given()
	 .body(createpost).when().post("/api/users").then().log().all()
	 .assertThat().statusCode(201).extract().response().asString();
 }

@DataProvider(name = "registerdetails")
public Object[][] getData() {
		 return new Object[][] {
			 {new CreatePost2().setName("michel")},
			 {new CreatePost2().setJob("technician")},
			 {new CreatePost2().setId(7)},
			 {new CreatePost2().setName("sofia")},
			 {new CreatePost2().setJob("teamleader")},
			 {new CreatePost2().setId(8)},
			 {new CreatePost2().setName("adam")},
			 {new CreatePost2().setJob("supervisor")},
			 {new CreatePost2().setId(9)}};
  }
}