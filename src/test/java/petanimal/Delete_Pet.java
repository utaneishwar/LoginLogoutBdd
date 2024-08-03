package petanimal;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Delete_Pet 
{
	@Test
	public void Delete_Pet_API()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Response response = given()
							.header("accept","application/json")
							.header("Content-Type","application/json")
							.header("api_key","sonu")
							
							.when()
							.delete("pet/1405")
							.then()
							.extract()
							.response();
		String data = response.asPrettyString();
		System.out.println(data);
		
		JsonPath jp = response.jsonPath();
		String message = jp.getString("message");
		System.out.println(message);
		
		
		System.out.println("delete pet API Successfully");
		
	}
}
