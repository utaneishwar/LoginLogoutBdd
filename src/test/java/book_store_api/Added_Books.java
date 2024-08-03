package book_store_api;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class Added_Books extends CommanData
{
	@Test
	public void Add_Books()
	{
		//String UUID = userId;
				RestAssured.baseURI=baseURL;
					Response CreateBooks= given()
										.header("Content-Type","application/json")
										.header("accept","application/json")
										.header("Authorization",token)
										.body("{\r\n"
												+ "  \"userId\": \"{userId}\",\r\n"
												+ "  \"collectionOfIsbns\": [\r\n"
												+ "    {\r\n"
												+ "      \"isbn\": \"{isbn}\"\r\n"
												+ "    }\r\n"
												+ "  ]\r\n"
												+ "}")
										.when()
										.post("/BookStore/v1/Books")
										.then()
										.extract()
										.response();
		  		
		 String resp_isbn = CreateBooks.asPrettyString();
     	 System.out.println("isbn response is: "+resp_isbn);
		 
	
}
}
