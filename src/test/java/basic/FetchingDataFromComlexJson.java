package basic;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchingDataFromComlexJson 
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
		
		JsonPath jp = resp.jsonPath();
		int totalpagesvalue = jp.getInt("total_pages");
		System.out.println(totalpagesvalue);  // 2

		String urlvalue = jp.getString("support.url");
		System.out.println(urlvalue);  // https://reqres.in/#support-heading
	
		int size = jp.getInt("data.size()");
		System.out.println(size);            // 6

		String lastnamevalue = jp.getString("data[0].last_name"); 
		System.out.println(lastnamevalue);      // lawson




	}

}
