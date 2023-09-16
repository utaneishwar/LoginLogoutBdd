package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Cookie;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Delayed_Response 
{
	@Test
	public void getuser()
	{
		RestAssured.baseURI="https://reqres.in/";

		Response resp = given()
				.when()
				.get("api/users?delay=3")
				.then()
				.extract()
				.response();
		
		String stringresponse = resp.asPrettyString();
		System.out.println(stringresponse);

		int stscode=resp.statusCode();
		System.out.println(stscode);  // 200

		long timetaken = resp.getTime();
		System.out.println(timetaken);  // fetch the time for execute and data from  server

		Cookie ret = resp.detailedCookie(basePath);
		System.out.println(ret);  // nothing add exra for vallidation or understanding purpose 



	}
}
