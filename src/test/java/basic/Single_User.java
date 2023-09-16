package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
public class Single_User 
{
	@Test
	public void getSingleUser()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response resp = given()
				.when()
				.get("api/users/2")
				.then()
				.extract()
				.response();

		String stringResponse=  resp.asPrettyString();
		System.out.println(stringResponse);

		int stscode = resp.statusCode();  // fetching the status code
		System.out.println(stscode);  // 200 

		Assert.assertEquals(stscode,200);

		long timetaken = resp.getTime();
		System.out.println(timetaken);     

		long rt = resp.time();
		System.out.println(rt);

		String line = resp.statusLine();
		System.out.println(line);   // fetch the statusline // HTTP/1.1 200 OK



	}
}
