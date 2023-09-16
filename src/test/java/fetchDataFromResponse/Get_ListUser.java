package fetchDataFromResponse;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Get_ListUser 
{
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
