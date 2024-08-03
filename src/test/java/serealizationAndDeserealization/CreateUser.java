package serealizationAndDeserealization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.RequestBody;
import pojo.ResponseBody;

public class CreateUser {

	@Test
	public void createUser()
	{    // pass the value as request 
		RequestBody requestBody = new RequestBody();

		requestBody.setId(0);
		requestBody.setUsername("Ederuser");
		requestBody.setFirstName("Eder");
		requestBody.setLastName("Mejia");
		requestBody.setEmail("eder.mejia@abc.com");
		requestBody.setPassword("Test@1234");
		requestBody.setPhone("998877665544");
		requestBody.setUserStatus(0);

		// set the value by using setter method using ref variable of RequestBody and define inside this class 
		// variable by using getter and setter method

		RestAssured.baseURI = "https://petstore.swagger.io/v2";

		ResponseBody resbody = given()

				.body(requestBody)             //  concept of Serialization it convert byte stream 

				.header("Content-Type", "application/json")

				.when()

				.post("/user")

				.then()

				.log().all()

				.extract()

				.response()                 // still  of code is creating object 

				.as(ResponseBody.class);    // concept of deserialization i.e. converting byte stream into java object
		// get response in the form of keys and values 
		// and this variable define inside a ResponseBody class so thats why here taken this class


		String messageValue= resbody.getMessage();

		System.out.println(messageValue);

		// note we can do serialization and deserialization by using some dependancies and that are 
		// jackson databind, jackson-core, jackson-annotation, gson 
		// other wise not possible it 

	}


}