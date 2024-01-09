package RestPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class CreateAndFetchUser 
{
	@Test
	public void createuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		Response resp = given()
						.body("{\r\n"
						+ "  \"id\": 0,\r\n"
						+ "  \"username\": \"uesrone\",\r\n"
						+ "  \"firstName\": \"Testing\",\r\n"
						+ "  \"lastName\": \"Batch\",\r\n"
						+ "  \"email\": \"TestingBatch@gmail.com\",\r\n"
						+ "  \"password\": \"Test@123\",\r\n"
						+ "  \"phone\": \"1234567891\",\r\n"
						+ "  \"userStatus\": 0\r\n"
						+ "}")
						.header("content-type","application/json")
						.when()
						.post("/user")
						.then()
						.extract()
						.response();
		String response = resp.asPrettyString();
		System.out.println(response);

	}
	@Test
	public void Fetchuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		Response response = given()
							.when()
							.get("/user/uesrone")
							.then()
							.extract()
							.response();
		String strresp = response.asPrettyString();
		System.out.println(strresp);

	}
}
