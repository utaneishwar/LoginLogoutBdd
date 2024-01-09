package ecom;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBodyData;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class Login_Api extends BasicData
{
	@Test
	public void loginToApp()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		Response response = given()
							.body("{\r\n"
									+ "    \"userEmail\": \"utanekishor@gmail.com\",\r\n"
									+ "    \"userPassword\": \"Test@123\"\r\n"
									+ "}")
							.header("Content-Type","application/json")
							.when()
							.post("/api/ecom/auth/login")
							.then()
							.extract()
							.response();

				String strResp = response.asPrettyString();
				System.out.println(strResp); 

				JsonPath jp = response.jsonPath();

		  		String idOfUser = jp.getString("userId");
		  		userId = idOfUser;
		  		System.out.println("User id is "+idOfUser);

		  		String tokenvalue = jp.getString("token"); // 
		  		System.out.println(tokenvalue);
		  		tokenid=tokenvalue;


	}

}
