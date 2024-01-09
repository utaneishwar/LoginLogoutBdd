package RestPractice;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class FetchingDataFromJsonMethod
{
	// here are three way to fetch data from response 
	 // using Json path method, json class, serealization and Deserealization.
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
		
		JsonPath jp = response.jsonPath();
           String uname = jp.getString("username");
           System.out.println(uname);  // this type que asked in interview
          System.out.println(jp.getLong("id")); 
	}
}


