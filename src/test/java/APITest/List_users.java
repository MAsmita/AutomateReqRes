package APITest;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import ResponsePojo.Response_single_user;

public class List_users {

public static void main(String[] args) {
	List_users.All_list_users();
	List_users.Delete_user();
	List_users.list_single_user();
	List_users.single_use_notfound();
	List_users.List_resources();
	List_users.List_single_resources();
	List_users.single_resource_notfound();
}
		        
public static void All_list_users() {
	given().spec(Utility.requestbuild()).queryParam("page", "2")
	.when().get("/api/users")
	.then().spec(Utility.responsebuild())
	.body("data.id", hasItems(7,8));    
  }      

public static void Delete_user() {
	 given().spec(Utility.requestbuild())
	.when().delete("/api/users/4")
	.then().assertThat().statusLine(containsString("204 No Content"));
  }	  

public static void list_single_user() {
	Response_single_user resp= given().spec(Utility.requestbuild())
	.when().get("/api/users/7").as(Response_single_user.class);
	System.out.println(resp.getAd().getUrl());
  }	      

public static void single_use_notfound() { 
	 given().spec(Utility.requestbuild())
	.when().get("/api/users/23")
	.then().assertThat().statusCode(404).statusLine(containsString("404 Not Found"));
  }		           

public static void List_resources() {  
	 given().spec(Utility.requestbuild())
	.when().get("/api/unknown")
	.then().spec(Utility.responsebuild()).body("per_page", equalTo(6));
  }			           
	
public static void List_single_resources() {  
	given().spec(Utility.requestbuild())
	.when().get("/api/unknown/2")
	.then().spec(Utility.responsebuild());
  }				           
	
public static void single_resource_notfound() { 
	given().spec(Utility.requestbuild())
	.when().get("/api/unknown/22")
	.then().assertThat().statusCode(404);
  }
}	
		
	

	