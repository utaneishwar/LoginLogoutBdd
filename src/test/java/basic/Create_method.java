package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Create_method
{
 @Test
 public void CreateResource ()
 {
	 RestAssured.baseURI="https://reqres.in/";
	Response resp = given()
			.body("name:morpheus")
			.when()
			.post("/api/users?page=23")
			.then()
			.extract()
			.response();
	 
	String stringresponse = resp.asPrettyString();
	System.out.println(stringresponse);
	
	
	int stscode = resp.statusCode();
	System.out.println(stscode);
	 
 }
}
