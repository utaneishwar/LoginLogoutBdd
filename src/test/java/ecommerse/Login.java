package ecommerse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class Login extends BaseData 
{
	@Test
	public void logintoApp()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com";
		Response resp = given()

				.header("Content-Type", "application/json")
				.body("{\r\n"
						+ "    \"userEmail\": \"kunalbhusari@gmail.com\",\r\n"
						+ "    \"userPassword\": \"Test@1234\"\r\n"
						+ "}")
				.when()
				.post("/api/ecom/auth/login")
				.then()
				.extract()
				.response();
		JsonPath jp = resp.jsonPath();
		String idOfUser = jp.getString("userId");
		userID =idOfUser;
		System.out.println(idOfUser);
		
		 String	tokenvalue=jp.getString("token");
		tokenid=tokenvalue;
		System.out.println(tokenvalue);
		 String messagetext = jp.getString("message");
		 message=messagetext;
		 System.out.println(messagetext);
		 System.out.println("**************");


	}
}
