package ser_des;

import io.restassured.RestAssured;
import ser_des.Data;
import ser_des.GetResponse;

import static io.restassured.RestAssured.*;

import java.util.List;

import org.testng.annotations.Test;

public class Get_ListUser 
{

	@Test
	public void getdeatil()
	{
		RestAssured.baseURI="https://reqres.in/" ;
		GetResponse response = given()
				.when()
				.get("/api/users?page=2")
				.then()
				.extract()
				.response()
				.as(GetResponse.class);                // deserialization concept

		Integer total = response.getTotal();
		System.out.println(total);  
		// 12
		List<Data> datalist = response.getData();  
		String firstname = datalist.get(2).getFirst_name();
		System.out.println(firstname);                     // Tobias

		Integer idvalue = datalist.get(0).getId();
		System.out.println(idvalue);    // 7




	}
}
