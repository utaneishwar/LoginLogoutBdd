
package petanimal;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static  io.restassured.RestAssured.*;

public class AddNewPetToTheStore 
{
	// Pet animal (mala) added in to the store and get detail from that Store 
	
	String body="{\r\n"
			+ "  \"id\": 1405,\r\n"
			+ "  \"category\":\r\n"
			+ " {\r\n"
			+ "    \"id\": 1,\r\n"
			+ "    \"name\": \"female\"\r\n"
			+ "  },\r\n"
			+ "  \"name\": \"mala\",\r\n"
			+ "  \"photoUrls\":\r\n"
			+ " [\r\n"
			+ "    \"https//:mala.com\"\r\n"
			+ "  ],\r\n"
			+ "  \"tags\":\r\n"
			+ " [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 0,\r\n"
			+ "      \"name\": \"Ishwar\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"status\": \"available\"\r\n"
			+ "}";
	@Test
	public void AddedPetMala()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		Response response = given()
							.header("accept","application/json") 
							.header("Content-Type","application/json")
							.body(body)
							.when()
							.post("/pet")
							.then()
							.extract()
							.response();
							
			String addedPetIntotheStore= response.asPrettyString();;
							
				System.out.println(addedPetIntotheStore);	
				System.out.println("Pet-animal Added In the store ");
	}
	@Test
	public void GetPetMala()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
			 Response response = given()
							.header("accept","application/json")
							.when()
							.get("/pet/1405")
							.then()
							.extract()
							.response();
							
			String getpetmalafromstore= response.asPrettyString();;
							
				System.out.println(getpetmalafromstore);	
				System.out.println("get-animal detail from the store ");
	}
}
