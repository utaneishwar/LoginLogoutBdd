package fetchDataFromResponse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class FetchingLastnameFromByron 
{
	@Test
	public void fetchingLastname()
	{
		RestAssured.baseURI="https://reqres.in";
		Response resp = given()
				.log().all()
				.when()
				.get("api/users?page=2")
				.then()
				.log().all()
				.extract()
				.response();

		JsonPath jp = resp.jsonPath();
		int datasize = jp.getInt("data.size()");

		
		
		for(int i=0; i<datasize; i++)
		{
			String firstname = jp.getString("data["+i+"].first_name");
			//System.out.println(firstname);
			
			if(firstname.equals("Byron"))
			{
				String lastname = jp.getString("data["+i+"].last_name");
				System.out.println(lastname);
			}
		}


	}

}
