package APITest;
import static io.restassured.RestAssured.given;
import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import pojo.CreateUser;

public class Deserialisation {

public static void main(String[] args) {
   
	RestAssured.baseURI = "https://reqres.in";
		CreateUser resp = given().queryParam("page", "2").expect().defaultParser(Parser.JSON)
		.when().get("/api/users").as(CreateUser.class);

		System.out.println(resp.getPage());
		System.out.println("First name: " + (resp.getData().get(1).getFirst_name()));
		System.out.println("company name: " + (resp.getAd().getCompany()));
 }
}
