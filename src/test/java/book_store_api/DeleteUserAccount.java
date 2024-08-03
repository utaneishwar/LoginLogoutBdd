package book_store_api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class DeleteUserAccount extends CommanData
{
	@Test
	public void Delete_User()
	{

		RestAssured.baseURI=baseURL;
		Response createUserResponse = given()
			                     	   .header("Authorization",token)
										.pathParam("UUID", userId)
										.body(RequestBodyBookStore.RequestBody())
										.when()
										.delete("/Account/v1/User/{UUID}")
										.then()
										.extract()
										.response();

//		String resp = createUserResponse.asPrettyString();
//		System.out.println(resp);


		JsonPath jp = createUserResponse.jsonPath();
		String code = jp.getString("code");
		String message = jp.getString("message");

		System.out.println("code is: "+code+"   message is: "+ message);

	}
}
