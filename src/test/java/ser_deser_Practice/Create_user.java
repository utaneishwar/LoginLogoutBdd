package ser_deser_Practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.RequestBody;
import pojo.ResponseBody;

import static io.restassured.RestAssured.*;

public class Create_user 
{
	@Test
	public void CreateUser()
	{

		RequestBody requestbody=new RequestBody();
								requestbody.setId(1);
								requestbody.setUsername("danie");
								requestbody.setFirstName("danie");
								requestbody.setLastName("eliana");
								requestbody.setEmail("elianadanie.com");
								requestbody.setPassword("danie123");
								requestbody.setPhone("1234567892");
								requestbody.setUserStatus(0);



		RestAssured.baseURI="https://petstore.swagger.io/v2";
     ResponseBody response = given()
							.body(requestbody)
							.header("Content-Type", "application/json")
							.when()
							.post("/user")
							.then()
							.log().all()
							.extract()
							.response()
		                    .as(ResponseBody.class); 

	}
}
