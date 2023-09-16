package ecom;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.*;
public class Delete_Api extends BasicData
{
	@Test
	public void delete_product()
	{
		RestAssured.baseURI="https://www.rahulshettyacademy.com";
		given()
		.header("Authorization", tokenid)
		.pathParam("prdid", productId)
		.when()
		.delete("/api/ecom/product/delete-product/{prdid}")
		.then()
		.log().all()
		.extract()
		.response();




	}

}
