package ser_deser_Practice;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import pojo.Data;
import pojo.Get_ResponseBody;
import pojo.Support;
import pojoPractice.GetresponseBody;
import pojoPractice.Support1;

import static io.restassured.RestAssured.*;

import java.util.List;
public class Get_ListUser
{
	@Test
	public void FetchData()
	{
		RestAssured.baseURI="https://reqres.in/";
		GetresponseBody response = given()
				                  .when()
				                  .get("/api/unknown")
				                  .then()
				                  .log().all()
				                  .extract()
				                  .response()
				                  .as(GetresponseBody.class);

		Support1 svalue = response.getSupport();
		String textvalue = svalue.getText();
		System.out.println(textvalue);  //ReqRes free, contributions towards server costs are appreciated!  

		List<pojoPractice.Data> data = response.getData();
		String namevalue = data.get(0).getName();
		System.out.println(namevalue);   // cerulean
		
		        System.out.println(response.getTotal()); // 12
		

	}

}
