package basic;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Post_CreatingUser
{
	 String messagevalue;
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
		  JsonPath js = resp.jsonPath();
		   messagevalue = js.getString("message");
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
		JsonPath js = resp.jsonPath();
		  String idvalue = js.getString("id");
		Assert.assertEquals(messagevalue , idvalue);    // verified
		 // fetch the data by using json method
		
		JsonPath jp =new JsonPath(strResp);
		System.out.println(jp.getString("firstName"));
		System.out.println(jp.getString("phone"));
		System.out.println(jp.getString("email"));
	}
}


