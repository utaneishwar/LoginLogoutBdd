package fetchDataFromResponse;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import basic.JsonBody;
public class API_Chaining 
{
	static String messagevalue;
	@Test(priority=1)
	public void createuser()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Response resp = given()
				.body(JsonBody.getbody())   // it is coming from another class as request
				.header("Content-Type","application/json")
				.when()
				.post("/user")
				.then()
				.extract()
				.response();
		
		String strResp = resp.asPrettyString();
		System.out.println(strResp);
		
		JsonPath jp = resp.jsonPath();
		messagevalue=jp.getString("message");
		
	}
	@Test(priority=2)
	public void geuserdetails()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Response resp = given()
				.when()
				.get("/user/kishorutane")
				.then()
				.extract()
				.response();
		String strResp = resp.asPrettyString();
		System.out.println(strResp);
		
		JsonPath jp = resp.jsonPath();
		String idvalue = jp.getString("id");
		System.out.println(idvalue);
		
		//Assert.assertEquals(idvalue, messagevalue);   // it is failure, first time will get sameid and message because it is post call
	}
}
