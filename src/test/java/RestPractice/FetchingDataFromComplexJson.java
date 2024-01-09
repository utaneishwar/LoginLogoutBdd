package RestPractice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
public class FetchingDataFromComplexJson
{
	@Test
	public void ListResource()
	{
		RestAssured.baseURI="https://reqres.in/";
		     Response resp = given()
		                   .log().all()
		                   .when()
		                   .get("/api/unknown")
		                   .then()
		                   .log().all()
		                   .extract()
		                   .response();
		      JsonPath jp = resp.jsonPath();  
         System.out.println(jp.getInt("total_pages"));  // 12
         
               String namevalue = jp.getString("data[0].name");
               System.out.println(namevalue);
               
                 
             
              
         
    }

}
