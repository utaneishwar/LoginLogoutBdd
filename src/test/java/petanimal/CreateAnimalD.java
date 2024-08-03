package petanimal;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.ResponseSpecification;

import static  io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;
public class CreateAnimalD 
{



	String path ="C:\\Users\\intel\\eclipse-workspace\\JanBatchRestAssured\\src\\test\\resources\\images\\Screenshot (705).png";
	//String path=System.getProperty("user.dir")+"\\src\\test\\resources\\images\\JeansPartyWomen.jpg";
	File file =new File(path);
	@Test
	public void CreatePetId()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Response response = given()
							.header("accept","application/json")
							.param("petId", 001)
							.param("additionalMetadata", "cow is my pet animal")
							.multiPart("petImage", file)
							.when()
							.post("/pet/001/uploadImage")
							.then()
							.extract()
							.response();
		String data = response.asPrettyString();
		System.out.println(data);
		System.out.println("request:"+response.statusCode());

		JsonPath jp = response.jsonPath();
		
		String code = jp.getString("code");
		System.out.println("code  is: "+code );
		String type = jp.getString("type");
		System.out.println("type  is: "+type );
		
		String message = jp.getString("message");
		System.out.println("message is: "+message);
		
		
		
	}

	@Test
	public void GetPetDetails()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Response response = given()
				.header("accept","application/json")
				.when()
				.get("/pet/001")
				.then()
				.extract()
				.response();
		String data = response.asPrettyString();
		System.out.println(data);
		System.out.println("response:"+response.statusCode());

	}




}
