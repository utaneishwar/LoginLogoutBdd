package ecommerse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;

public class DeleteProductApi extends BaseData
{
	@Test 
	public void delete_Product()
	{
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		given()
		.header("Authorization",tokenid)
		.pathParam("prdid", productID)
		.when()
		.delete("api/ecom/product/delete-product/{prdid}")
		.then()
		.log().all()
		.extract()
		.response();
		

	}
}
