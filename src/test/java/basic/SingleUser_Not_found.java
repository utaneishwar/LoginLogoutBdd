package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class SingleUser_Not_found 
{
	@Test
	public void sunf()
	{
		RestAssured.baseURI ="https://reqres.in/";
		Response resp = given()
				.when()
				.get("api/users/23")
				.then()
				.extract()
				.response();

		String responsbodydata = resp.asPrettyString();
		System.out.println(responsbodydata);

		long timetaken = resp.getTime(); 
		System.out.println(timetaken);  // time to execute and fetch the data 

		int stscode = resp.statusCode();
		System.out.println(stscode);  // 404   not found 


		String line = resp.getStatusLine();
		System.out.println(line);   // HTTP/1.1 404 Not Found  // fetch the status line
	}

}
