package fetchDataFromResponse;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.Test;
public class FetchingEmail_AddresFromJson 
{
	@Test
	public void fetchingemail()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response resp = given()
				.log().all()
				.when()
				.get("/api/users?page=2")
				.then()
				.log().all()
				.extract()
				.response();

		JsonPath jp = resp.jsonPath();
		int datasize= jp.getInt("data.size()");
		System.out.println(datasize);

		for(int i=0; i<=datasize; i++)
		{  

			String emailforall = jp.getString("data["+i+"].email");
			System.out.println(emailforall);
		}

	}

}
