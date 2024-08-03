package book_store_api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
public class Create_user_bookstore extends CommanData 
{
	
	@Test
	public void create_user()
	{

				RestAssured.baseURI=baseURL;
		  Response createUserResponse = given()
										.header("Content-Type","application/json")
										.header("accept","application/json")
										.body(RequestBodyBookStore.RequestBody())
										.when()
										.post("/Account/v1/User")
										.then()
										.extract()
										.response();
		  		
		 String resp = createUserResponse.asPrettyString();
//		 System.out.println(resp);
		 
		 
		 JsonPath jp = createUserResponse.jsonPath();
		   userId= jp.getString("userID");
		   username= jp.getString("username");
		   
		   System.out.println("userid is: "+userId+"  username is: "+  username);
		  
	}
}
