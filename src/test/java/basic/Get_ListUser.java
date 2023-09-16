package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

public class Get_ListUser 
{
	@Test
	public  void getuser()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response resp = given()
				.when()
				.get("/api/users?page=2")
				.then()
				.extract()
				.response();
		String stringResponse = resp.asPrettyString();
		System.out.println(stringResponse);

		int stscode = resp.statusCode();    // fetching the status code
		System.out.println(stscode);        // 200

		Assert.assertEquals(stscode, 200); 

		long timetaken = resp.getTime(); // time to execute and fetch the data

		System.out.println(timetaken);   

	}
}
