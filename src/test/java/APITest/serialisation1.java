package APITest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import pojo.CreatePost;

public class serialisation1 {

	public static void main(String[] args) {
		
		// 1..SERIALISATION 
		CreatePost c=new CreatePost();
		      c.setId(7);
		      c.setName("morpheus");
		      c.setEmail("morp.lead@reqres.in");
		      c.setJob("leader");
		
		RestAssured.baseURI="https://reqres.in";
        	String response= given().log().all().header("Content-Type","application/json")
        			.body(c)
        			.when().post("api/users")
        			.then().assertThat().statusCode(201).header("Server", "cloudflare").extract().response().asString();
	       System.out.println(response);
	      
	    JsonPath js= new JsonPath(response);
          	String actualjob = js.get("job");
          	System.out.println("job title: "+actualjob);
		
		// 2..UPDATE JOB INFORMATION
		RestAssured.baseURI="https://reqres.in";
	       String response1=given().queryParam("page","2")
	    		   .body("{\r\n" + 
	         		"    \"name\": \"morpheus\",\r\n" + 
	         		"    \"job\": \"zion resident\"\r\n" + 
	         		"}")
	    		   .when().put("/api/users/2")
	    		   .then().assertThat().statusCode(200).body("job", equalTo("zion resident")).extract().response().asString();
		     
	     JsonPath js1= new JsonPath(response1); 
	            String updatedjob=js1.get("job");
	            System.out.println(updatedjob);   //it is giving error showing job is null.

	    
	
	
	}

}
