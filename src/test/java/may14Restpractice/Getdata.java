package may14Restpractice;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Getdata 
{
	public static String messvalue;
	@Test(priority=1)
	public void getuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Response response = given()
							.body(JsonBody.redimadeJsonBody())
							.header("Content-Type", "application/json")
							.header("Accept", "application/json")
							.when()
							.post("/user")
							.then()
							.extract()
							.response();


		String data = response.asPrettyString();
		System.out.println(data);
		JsonPath jp = response.jsonPath();
		messvalue = jp.getString("message");

		System.out.println(messvalue );   // 
	}

	@Test(priority=2)
	public void fetchuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Response response = given()
							.when()
							.get("/user/testuser")
							.then()
							.extract()
							.response();


		String dataresp = response.asPrettyString();
		System.out.println(dataresp);

		JsonPath jp = response.jsonPath();
		String idvalue = jp.getString("id");
		Assert.assertEquals(messvalue, idvalue);
		System.out.println("pass test case");
		
		
		System.out.println(jp.getString("email"));
	}
}
