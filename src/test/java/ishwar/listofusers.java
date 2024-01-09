package ishwar;



import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class listofusers
{
	@Test
	public void fetchuser()
	{
		RestAssured.baseURI="https://reqres.in/";
		Response response = given()
							.when()
							.get("api/users?page=2")
							.then()
							.extract()
							.response();
		
		 System.out.println(response);
		 
		  String responsebody = response.asPrettyString();
		  System.out.println(responsebody);             // given Response body in systematic manner
		  System.out.println(response.statusCode());     // 200 
        

		// by using json method 
		JsonPath jrb = response.jsonPath();
		String url = jrb.getString("support.url");
		System.out.println(url);   // get url 


		int dataid =jrb.getInt("data[0].id");
		System.out.println(dataid);  // 7
		
		String dataName =jrb.getString("data[3].first_name");   
		System.out.println(dataName);  // byron 
		
		int datasize=jrb.getInt("data.size()");
		System.out.println(datasize);      //6

		for(int i=0; i<datasize; i++)
		{
			String email = jrb.getString("data["+i+"].email");
			//	System.out.println(email);                       // we get all mail 

			String name = jrb.getString("data["+i+"].first_name");
			//System.out.println(name); 

			if(name.equals("George") && email.equals("george.edwards@reqres.in"))
			{
				System.out.println( jrb.getString("data["+i+"].last_name"));  // Edwards
			}
			if(email.equals("rachel.howell@reqres.in"))
			{
				System.out.println(jrb.getString("data["+i+"].avatar"));
			}



		}



	}
}

