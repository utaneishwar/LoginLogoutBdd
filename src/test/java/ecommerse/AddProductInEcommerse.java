package ecommerse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.io.File;

public class AddProductInEcommerse extends  BaseData
{
	@Test
	public static void add_Product()
	{
		
		String path=System.getProperty("user.dir")+"\\src\\test\\resources\\images\\JeansPartyWomen.jpg";
		File file =new File(path);

		RestAssured.baseURI="https://rahulshettyacademy.com/";
		
				
		Response resp = given()
		
		.header("Authorization",tokenid)
		
		
		
		.param("productName", "party wear shirt")
		.param("productAddedBy", userID)
		.param("productCategory", "Fashion")
		.param("productSubCategory", "shirt")
		.param("productPrice", "1500")
		.param("productDescription", "allen vally shirt")
		.param("productFor", "men")
		.multiPart("productImage", file)
		
		.when()
		.post("api/ecom/product/add-product")
		.then()
		.log().all()
		.extract()
		.response();
		
		JsonPath jp = resp.jsonPath();
		productID=jp.getString("productId");
		
		System.out.println(productID);
		String message = jp.getString("message");
     	System.out.println(message);
		
		 
	}
}
