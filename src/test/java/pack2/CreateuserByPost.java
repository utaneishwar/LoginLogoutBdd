package pack2;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class CreateuserByPost 
{
	@Test
	public void createAndget()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
			Response resp = given()
			.body("{\r\n"
					+ "  \"id\": 0,\r\n"
					+ "  \"username\": \"PriyankaDsuza\",\r\n"
					+ "  \"firstName\": \"priyanka\",\r\n"
					+ "  \"lastName\": \"Dsuza\",\r\n"
					+ "  \"email\": \"pdsuza@gmail.com\",\r\n"
					+ "  \"password\": \"Test@123\",\r\n"
					+ "  \"phone\": \"456\",\r\n"
					+ "  \"userStatus\": 0\r\n"
					+ "}")
			.header("Content-Type","application/json")
			.when()
			.post("/user")
			.then()
			.extract()
			.response();
			
			String response = resp.asPrettyString();
			System.out.println(response);
			
		
	}
	@Test
	public void getuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		Response getresponse = given()
		.when()
		.get("/userPriyankaDsuza\\")
		.then()
		.extract()
		.response();
		
		String res = getresponse.asPrettyString();
		System.out.println(res);
		
	}
	

}
