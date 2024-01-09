package ishwar;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class CreateuserInDatabase 
{
	@Test(priority=1)
	public void usercreate()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";

		Response regresp = given()
				.body("{\r\n"
						+ "  \"id\": 0,\r\n"
						+ "  \"username\": \"Manisha\",\r\n"
						+ "  \"firstName\": \"Manisha\",\r\n"
						+ "  \"lastName\": \"utane\",\r\n"
						+ "  \"email\": \"utanepayal@gmail.com\",\r\n"
						+ "  \"password\": \"payal@123\",\r\n"
						+ "  \"phone\": \"8975780260\",\r\n"
						+ "  \"userStatus\": 0\r\n"
						+ "}")
				.header("content-type","application/json")
				.when()
				.post("/user")
				.then()
				.extract()
				.response();
		String resp = regresp.asPrettyString();
		System.out.println(resp);	 

		System.out.println(regresp.statusCode());    //201	
	}

	@Test(priority=2)
	public void userfetch()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";

		Response userresponse = given()
				           .when()
				           .get("/user/Manisha")
				           .then()
				           .log().all()
				           .extract()
				           .response();
		
		
		JsonPath jrb = userresponse.jsonPath();
		System.out.println(jrb.getString("lastName"));  //
	}

}
