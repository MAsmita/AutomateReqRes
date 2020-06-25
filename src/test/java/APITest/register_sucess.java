package APITest;
import static org.hamcrest.Matchers.*;
import pojo.CreateUser;
import static io.restassured.RestAssured.*;

public class Register_sucess {
	public static void main(String[] args) {
		Register_sucess.Register_successful();
		Register_sucess.Register_Unsuccessful();
		Register_sucess.Login_Successful();
		Register_sucess.Login_Unsuccessful();
		Register_sucess.Delayed_response();
 }
		
public static void Register_successful() {
	given().spec(Utility.requestbuild()).body(Payload.register())
    .when().post("/api/register")
	.then().spec(Utility.responsebuild()).assertThat()
	.body("id", equalTo(4)).extract().response().asString();
  }
		
public static void Register_Unsuccessful(){
	 given().spec(Utility.requestbuild()).body(Payload.register_unsuccess())
	.when().post("/api/register")
	.then().assertThat().statusCode(400).body("error",equalTo("Missing password"))
	.extract().response().asString();
  }

public static void  Login_Successful(){
	 given().spec(Utility.requestbuild()).body(Payload.login())
	.when().post("/api/login")
	.then().spec(Utility.responsebuild()).assertThat()
	.body("token",equalTo("QpwL5tke4Pnpja7X4")).extract().response().asString();
  }
	
public static void  Login_Unsuccessful(){
	 given().spec(Utility.requestbuild()).body(Payload.unsuccessful_login())
	.when().post("/api/login")
	.then().assertThat().statusCode(400).body("error",equalTo("Missing password"))
	.extract().response().asString();
  }
	
public static void   Delayed_response(){
	CreateUser response = given().spec(Utility.requestbuild()).queryParam("delayed","3")
	.when().get("/api/users").as(CreateUser.class);
	 System.out.println(response.getPage());
  }
}
