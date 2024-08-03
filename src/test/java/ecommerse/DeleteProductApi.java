package ecommerse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class DeleteProductApi extends BaseData
{
	@Test 
	public void delete_Product()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		Response resp = given()
						 .header("Authorization",tokenid)
						 .pathParam("prdid", productID)
						 .when()
						 .delete("api/ecom/product/delete-product/{prdid}")
						 .then()
						//.log().all()
						.extract()
						.response();


		JsonPath jp = resp.jsonPath();
		System.out.println(jp.getString("message"));

	}
}
