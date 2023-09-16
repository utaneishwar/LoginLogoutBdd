package fetchDataFromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UsingJsonPathMethod 
{
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
		JsonPath jp = resp.jsonPath();
		String uname = jp.getString("username"); 
		System.out.println(uname);

		long idvalue = jp.getLong("id");
		System.out.println(idvalue);
		
		String fname = jp.getString("firstName");  // fetch data from json response
		System.out.println(fname);
		
		String vemail = jp.getString("email");
		System.out.println(vemail);
	}
}
