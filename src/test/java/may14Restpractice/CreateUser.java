package may14Restpractice;



import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class CreateUser
{
	
	static int valueofmessage ;
	@Test(priority=1)
	public static void requestbody()
	{
	   //Here i am use serealization And deserealization concept
		SwaggerCreateUser sw =new SwaggerCreateUser();  
		  // set the value into the " sw " Object"
						    sw.setId(10);
							sw.setUsername("Kishori");
		                    sw.setFirstName("Kishor");
		                    sw.setLastName("Utane");
		                    sw.setEmail("utane@gmail.com");
		                    sw.setPassword("K@123");
		                    sw.setPhone("8788584614");
		                    sw.setUserStatus(100);
		                 	
		    // code of Create Request that means create user into the database              	
		RestAssured .baseURI="https://petstore.swagger.io/v2";
	       PojoResponse request = given()
	    		   				.body(sw)
	    		   				.header("Content-Type", "application/json")
	    		   				.header("Accept", "application/json")
				                .when()
						        .post("/user")
						        .then()
						       // .log().all()
						       .extract()
						       .response()
						      .as(PojoResponse.class);
	       
	              String  messvalue = request.getMessage();
	              // convert the String value into the Integer;
	              int valueofmessage = Integer.parseInt(messvalue);
	                System.out.println(valueofmessage );
	                System.out.println("This is my request output ");
	}
	@Test(priority=2)
	public static void responsebody()
	{
		// fetch user value  base on the request that we are set into the database.
		     // code of fetch data from the database.
		   RestAssured .baseURI="https://petstore.swagger.io/v2";
	       SwaggerCreateUser request = given()
	    		   				.when()
				             	.get("/user/Kishori")
				             	.then()
				             	.extract()
				             	.response()
				             	.as(SwaggerCreateUser.class);
	       				Integer id = request.getId();  //10
	                      System.out.println(id);
	                      System.out.println("this is my response output");
	                      Assert.assertEquals(id,  valueofmessage);
	                     // Assert.assertNotEquals(id, messvalue);
	                      System.out.println("This is my response output 2 nd");
// -----------------------------------------------------------------------------------
	                      //
	                    //List<Data> data = request.getData();
	                    //for(int i=0; i<data.size(); i++)
	                    //{
//	                    	String datavalue = data.get(i).getFirst_name();
//	                    	System.out.println(datavalue);
	                    //}
	                    //
	                    //String textvalue= request.getSupport().getText();
	                    //System.out.println(textvalue);
	                    //System.out.println( data.get(2).getLast_name());
	}
	
}




