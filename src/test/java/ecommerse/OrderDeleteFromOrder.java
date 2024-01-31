package ecommerse;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class OrderDeleteFromOrder extends BaseData
{
	@Test
	public void deleteOrder()
	{
//		String tokenid="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2NTZhZjE3ZDlmZDk5Yzg1ZThkZGFlMGMiLCJ1c2VyRW1haWwiOiJrdW5hbGJodXNhcmlAZ21haWwuY29tIiwidXNlck1vYmlsZSI6ODc4ODU4NDYxMSwidXNlclJvbGUiOiJjdXN0b21lciIsImlhdCI6MTcwNjYxNTUzMSwiZXhwIjoxNzM4MTczMTMxfQ.DC0mblR2hr75VOMPTxdb4DvzGNkEdgRGo46Hbs6eCds";
		//String orderId=ordersID;
//https://rahulshettyacademy.com/api/ecom/order/delete-order/65ba1664a86f8f74dc684752
		RestAssured.baseURI="https://rahulshettyacademy.com/";
		Response resp = given()
						.header("Authorization",tokenid)
						.header("Content-Type", "application/json")
						 .pathParam("orderId", ordersID)
						.when()
						.delete("/api/ecom/order/delete-order/{orderId}") //")
						.then()
						.extract()
						.response();
		String responsepretty = resp.asPrettyString();
		System.out.println(responsepretty );
		
		JsonPath jp = resp.jsonPath();
		String message = jp.getString("message");
		
		System.out.println(message); //Orders Deleted Successfully
		
		System.out.println("**********");
		
		
	}
	
}
