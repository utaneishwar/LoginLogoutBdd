package ecom;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

import org.testng.annotations.Test;


public class AddProduct_intoApp extends BasicData
{

	@Test
	public void addProductToApp()
	{

		String path = System.getProperty("user.dir")+ "\\src\\test\\resources\\images\\JeansPartyWomen.jpg";
		File file = new File(path);

		RestAssured.baseURI = "https://rahulshettyacademy.com";

		Response response = given()

				.header("Authorization", tokenid)

				.param("productName", "Party wear Jeans")
				.param("productAddedBy", userId)
				.param("productCategory", "fashion")
				.param("productSubCategory", "Trouser")
				.param("productPrice", "2000")
				.param("productDescription", "Levis Jeans")
				.param("productFor", "Women")
				.multiPart("productImage", file)      // this method used for upload the file 

				.when()

				.post("/api/ecom/product/add-product")

				.then()

				.log().all()

				.extract()

				.response();

		JsonPath jp = response.jsonPath();

		productId = jp.getString("productId");

	}
}


