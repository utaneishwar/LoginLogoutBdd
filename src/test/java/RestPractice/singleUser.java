package RestPractice;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;
public class singleUser
{
	@Test
	public void SingleUser()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response resp = given()
						.when()
						.get("/api/users/2")
						.then()
						.extract()
						.response();
		String stringresp = resp.asPrettyString();
		System.out.println(stringresp);
		
		int stscode = resp.statusCode();
		System.out.println(stscode);
		
		assertEquals(stscode, 200);

	}


}
