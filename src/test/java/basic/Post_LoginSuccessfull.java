package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Post_LoginSuccessfull
{
	@Test
	public void login()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response resp = given()
		.body("{\r\n"
				+ "    \"email\": \"eve.holt@reqres.in\",\r\n"
				+ "    \"password\": \"cityslicka\"\r\n"
				+ "}")
		.header("Content-Type","application/json")
		.when()
		.post("/api/login")
		.then()
		.extract()
		.response();
		
		String strresp = resp.asPrettyString();
		System.out.println(strresp);
		
		int stscode = resp.statusCode();
		System.out.println(stscode);
		
	long timeresp = resp.getTime();
	System.out.println(timeresp);
		
		
		
		
	}

}
