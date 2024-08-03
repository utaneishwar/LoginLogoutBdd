package petanimal;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Update_Existing_Pet 
{
	String body="{\r\n"
			+ "  \"id\": 1405,\r\n"
			+ "  \"category\": {\r\n"
			+ "    \"id\": 0,\r\n"
			+ "    \"name\": \"string\"\r\n"
			+ "  },\r\n"
			+ "  \"name\": \"sonu\",\r\n"
			+ "  \"photoUrls\": [\r\n"
			+ "    \"https//:mala.com\"\r\n"
			+ "  ],\r\n"
			+ "  \"tags\": [\r\n"
			+ "    {\r\n"
			+ "      \"id\": 0,\r\n"
			+ "      \"name\": \"ishwar\"\r\n"
			+ "    }\r\n"
			+ "  ],\r\n"
			+ "  \"status\": \"available\"\r\n"
			+ "}";
	@Test
	public void updatePetMala()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		Response response = given()
							.header("accept","application/json") 
							.header("Content-Type","application/json")
							.body(body)
							.when()
							.put("/pet")
							.then()
							.extract()
							.response();
							
			String update_pet_From_Store= response.asPrettyString();;
							
				System.out.println(update_pet_From_Store);	
				System.out.println("Pet-animal updated In the store ");
	}
	
}
