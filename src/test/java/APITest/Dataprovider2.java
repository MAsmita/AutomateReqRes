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
			 {new CreatePost2("michel", "technician")},
			 {new CreatePost2("michel2", "technician2")}
			 };
  }
}