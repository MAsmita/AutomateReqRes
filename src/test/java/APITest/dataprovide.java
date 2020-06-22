package APITest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class dataprovide {
	
	
	@Test(dataProvider="Registerdetails")
	public void userregistration(String name,String job,int id)
	    {

	   RestAssured.baseURI="https://reqres.in";
	   String response= given().header("Content-Type","application/json")
	             .body(Payload.create_multiple_user(name, job, id))
	             .when().post("/api/users")
	             .then().log().all().assertThat().statusCode(201).extract().response().asString();
             
		 System.out.println(response);
	    }

	@DataProvider(name="Registerdetails")
	public Object[][] getdata()
	{
		return new Object[][] {{"michel","technician",7},{"sofia", "teamleader",8},{"adam","supervisor",9}};
	}

}

	