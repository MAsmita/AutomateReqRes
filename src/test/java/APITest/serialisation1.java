package APITest;
import static io.restassured.RestAssured.given;
import ResponsePojo.response_create_user;
import ResponsePojo.response_update_job;
import pojo.CreatePost;

public class Serialisation1 {
    public static void main(String[] args) {
    	Serialisation1.create_user_pojo(); 
    	Serialisation1.Update_job_info();
 }
		
public static void create_user_pojo() {	
	CreatePost c = new CreatePost();
	c.setId(7);
	c.setName("morpheus");
	c.setEmail("morp.lead@reqres.in");
	c.setJob("leader");
		
	response_create_user response = given().spec(Utility.requestbuild())
	.body(c).when().post("api/users")
	.as(response_create_user.class);
  
	System.out.println(response.getCreatedAt());
	System.out.println(response.getEmail());
	System.out.println(response.getId());
 }	
  
public static void Update_job_info() {
	CreatePost cp = new CreatePost();
    cp.setName("morpheus");
	cp.setJob("zion resident");
	cp.setEmail("morp.zion@reqres.in");
	cp.setId(7);
	    	
	response_update_job resp = given().spec(Utility.requestbuild()).queryParam("page","2")
	.body(cp).when().put("/api/users/2").as(response_update_job.class);
	
	System.out.println("Updated Job: "+resp.getJob());
	System.out.println("Updated Email: "+resp.getEmail());
  }	
}
