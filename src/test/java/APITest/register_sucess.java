package APITest;

import static org.hamcrest.Matchers.*;

import io.restassured.path.json.JsonPath;

import static io.restassured.RestAssured.*;

public class register_sucess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
    //Register Successful
	String response= given().spec(Utility.requestbuild()) 
		             .body(Payload.register())
                     .when().post("/api/register")
                     .then().spec(Utility.responsebuild()).assertThat().body("id",equalTo(4)).extract().response().asString();
             System.out.println(response);
    
     //Register Unsuccessful
	 String unsuccessregister =given().spec(Utility.requestbuild())
                        .body(Payload.register_unsuccess())
                        .when().post("/api/register")
                        .then().assertThat().statusCode(400).body("error",equalTo("Missing password")).extract().response().asString();
	          System.out.println(unsuccessregister);
	    
	//Login Successful
	String loginresp= given().spec(Utility.requestbuild())
                      .body(Payload.login())
                      .when().post("/api/login")
                      .then().spec(Utility.responsebuild()).assertThat()
                      .body("token",equalTo("QpwL5tke4Pnpja7X4")).extract().response().asString();
               System.out.println(loginresp);
                     
    //Login unsuccessful             
    String unsuccesslogin= given().spec(Utility.requestbuild())
                             .body(Payload.unsuccessful_login())              
                             .when().post("/api/login")
                             .then().assertThat().statusCode(400).body("error",equalTo("Missing password")).extract().response().asString();;
                 System.out.println(unsuccesslogin);  
                           
     
     //Delayed response                 
     String delayedresp= given().spec(Utility.requestbuild()).queryParam("delayed", "3")
	           .when().get("/api/users")
               .then().spec(Utility.responsebuild()).extract().response().asString();
	            
               JsonPath js=new JsonPath(delayedresp);
               String page=js.getString("per_page");
               System.out.println("per_page: "+ page);
               System.out.println(js.get("data[1]"));                                
}
	
}