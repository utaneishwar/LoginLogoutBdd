package petanimal;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import petpojo.PojoOfRestApi;

import static io.restassured.RestAssured.*;
public class ResponseOfRestExamAPI 
{
	@Test
	public void response()
	{
		//set the values inside the class through users  // first time get response otherwise get exception
		RequestOfRestExample req =new RequestOfRestExample();
		
									req.setName("MIS");
									req.setSalary("90000");
									req.setAge("33");
		
		RestAssured.baseURI="https://dummy.restapiexample.com";
	    PojoOfRestApi response = given()
							.header("Content-Type","application/json")
							.header("Accept","application/json")
							.body(req)
							.when()
							.post("/api/v1/create")
							.then()
							.extract()
							.response()
							.as(PojoOfRestApi.class);
	System.out.println(response.getStatus());
	System.out.println(response.getData().getName());
	System.out.println(response.getData().getSalary());
	System.out.println(response.getData().getAge());
	System.out.println(response.getData().getId());
	System.out.println(response.getMessage());
	
	}
}
