package serealizationAndDeserealization;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import pojo.Data;
import pojo.Get_ResponseBody;
import pojo.Support;

public class Get_ListUsers {


	@Test
	public void getUsers()
	{
		RestAssured.baseURI = "https://reqres.in/";

		Get_ResponseBody responseBody = given()

				.when()

				.get("/api/users?page=2")

				.then()

				.extract()

				.response()

				.as(Get_ResponseBody.class);  // concept of serialization 

		Integer totalvalue = responseBody.getTotal();

		System.out.println(totalvalue);              // 12

		Support support = responseBody.getSupport();   // this method will give the object of support class

		String textvalue = support.getText();

		System.out.println(textvalue);                //	To keep ReqRes free, contributions towards server costs are appreciated!


		//	WAP to fetch the third id value from the json response

		List<Data> datavalue = responseBody.getData();  // 
		Integer idvalue = datavalue.get(3).getId();
		System.out.println(idvalue);                    // 10
		
		




	}
}
