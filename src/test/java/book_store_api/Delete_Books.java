package book_store_api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Delete_Books extends CommanData
{
	@Test
	public void Delete_books()
	{
				
				RestAssured.baseURI=baseURL;
				Response Delete_Books= given()
										
										.header("accept","application/json")
										.header("Authorization",token)
										.pathParam("userID", userId)
										.when()
										.delete("/BookStore/v1/Books?UserId={userID}")
										.then()
										.extract()
										.response();
		  		
		 String Resp_UserId_Message = Delete_Books.asPrettyString();
     	 System.out.println("DeleteBooks response : "+Resp_UserId_Message);
		 
}
}
