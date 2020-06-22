package APITest;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utility {

	public static RequestSpecification requestbuild() 
	 {
		
		RequestSpecification reqspec =new RequestSpecBuilder().setBaseUri("https://reqres.in")
				.addHeader("Content-Type", "application/json").build();
		        return reqspec;
	 }
	
    public static ResponseSpecification responsebuild()
    {
    	
		ResponseSpecification resspec =new ResponseSpecBuilder().expectStatusCode(200).expectHeader("Content-Type", "application/json; charset=utf-8").build();
    	          return resspec;
    }
    
   
}