package ecommersePractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class LoginApiPr 
{
	@Test
	public void Login()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		 Response response = given()
		                    .when()
		                    .post()
		                    .then()
		                    .extract()
		                    .response();
		                    
		                    
		                    
		                    
		                    
	}
}
