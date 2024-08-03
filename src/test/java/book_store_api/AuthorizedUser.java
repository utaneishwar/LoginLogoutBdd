package book_store_api;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

import io.restassured.response.Response;

public class AuthorizedUser extends CommanData
{

	@Test
	public void Authorized_user()
	{
		
		RestAssured.baseURI=baseURL;
		  Response createUserResponse = given()
										.header("Content-Type","application/json")
										.header("accept","application/json")
										.header("Authorization",token)
										.body(RequestBodyBookStore.RequestBody())
										.when()
										.post("/Account/v1/Authorized")
										.then()
										.extract()
										.response();
		  		
		 String resp_true = createUserResponse.asPrettyString();
		 System.out.println(resp_true);
		 
 //         if gets failed 
//		    JsonPath jp = createUserResponse.jsonPath();
//		    String code = jp.getString("code");
//		    String message = jp.getString("message");
//		   
//		   System.out.println("code is: "+code+"   message is: "+ message);
		  
	}

}
