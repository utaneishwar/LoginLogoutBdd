package book_store_api;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import booksPojo.Books;
import booksPojo.BooksPojo;
import io.restassured.RestAssured;
import petanimal.Pojo_of_petanimals;

import static io.restassured.RestAssured.*;


public class Get_Details_Of_Books extends CommanData
{



	@Test
	public void Books_Detail()
	{

		RestAssured.baseURI=baseURL;
		BooksPojo GetBooksResponse = given()

										.header("accept","application/json")
										.when()
										.get("/BookStore/v1/Books")
										.then()
										.extract()
										.response()
										.as(BooksPojo.class);

		isbn = GetBooksResponse.getBooks().get(0).getIsbn();
		
//		for(int i=0; i<GetBooksResponse.getBooks().size(); i++)
//		{
//		String value = GetBooksResponse.getBooks().get(i).getIsbn();
//		System.out.println(value);
//		}
	
		
		
	}
}
