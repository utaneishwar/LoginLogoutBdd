package book_store_api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GenerateTokenOfUser extends CommanData
{
	@Test
	public void GenerateToken()
	{
		
		RestAssured.baseURI=baseURL;
		  Response createUserResponse = given()
										.header("Content-Type","application/json")
										.header("accept","application/json")
										.body(RequestBodyBookStore.RequestBody())
										.when()
										.post("/Account/v1/GenerateToken")
										.then()
										.extract()
										.response();
		  		
		 String resp = createUserResponse.asPrettyString();
//		 System.out.println(resp);
		 
		 
		 JsonPath jp = createUserResponse.jsonPath();
		   token= jp.getString("token");
		  
		   String result = jp.getString("result");
		   
		   System.out.println("TokenID is: "+token+"  Result is: "+result);
		  
	}
}
