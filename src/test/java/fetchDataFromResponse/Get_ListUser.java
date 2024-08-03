package fetchDataFromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_ListUser 
{
	// Which are the dependancy used for automation in API Testing
	// Rest asssured, testng, jackson annotation, json simple, jackson databinding, 
	
	@Test
	public  void getuser()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response resp = given()
				.log().all()
				.when()
				.get("/api/users?page=2")
				.then()
				.log().all()
				.extract()
				.response();
	}

}
