package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Post_CreatingUser
{
	@Test
	public void creteUser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Response resp = given()
				.body("{\r\n"
						+ "  \"id\": 0,\r\n"
						+ "  \"username\": \"Daniel\",\r\n"
						+ "  \"firstName\": \"S\",\r\n"
						+ "  \"lastName\": \"smith\",\r\n"
						+ "  \"email\": \"daniel@gmail.com\",\r\n"
						+ "  \"password\": \"Pass@1234\",\r\n"
						+ "  \"phone\": \"8788888888\",\r\n"
						+ "  \"userStatus\": 0\r\n"
						+ "}")
				.header("Content-Type","application/json")
				.when()
				.post("/user")
				.then()
				.extract()
				.response();

		String strResp = resp.asPrettyString();
		System.out.println(strResp);

	}

	@Test
	public void getUserDetails()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Response resp = given()
				.when()
				.get("/user/Daniel")
				.then()
				.extract()
				.response();
		
		String strResp = resp.asPrettyString();
		System.out.println(strResp);


	}

}
