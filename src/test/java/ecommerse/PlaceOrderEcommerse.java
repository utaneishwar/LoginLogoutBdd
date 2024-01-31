package ecommerse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;


public class PlaceOrderEcommerse extends BaseData
{
	@Test
	public void PlaceOrder()
	{
		RestAssured.baseURI="https://www.rahulshettyacademy.com/";
		Response res = given()
		.header("Authorization",tokenid)
		.header("Content-Type","application/json")
		.body("{\"orders\": [\r\n"
				+ "        {\r\n"
				+ "        \"country\": \"India\", \r\n"
				+ "        \"productOrderedId\" : \""+productID+"\"\r\n"
				+ "        }\r\n"
				+ "    ]\r\n"
				+ "}")
		.when()
		.post("api/ecom/order/create-order")
		.then()
	//	.log().all()
		.extract()
		.response();
		JsonPath jp = res.jsonPath();
	 String order_id = jp.getString("orders[0]");  // [65ba1bbea86f8f74dc6851c5]
	
	 System.out.println(order_id);
	 ordersID =order_id;
	 System.out.println(jp.getString("message")); // "Order Placed Successfully"
	 System.out.println("************");
	}
		
		
		
		
		
	}

