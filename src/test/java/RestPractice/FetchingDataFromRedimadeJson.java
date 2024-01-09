package RestPractice;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

import static io.restassured.RestAssured.*;
public class FetchingDataFromRedimadeJson 
{
       // here we discussed by using json class  fetch the data from response
	   // most imp for interview prespective;
	
	@Test
	public void ComlexJson()
	{
		String json = "{\r\n"
				+ "\"dashboard\": {\r\n"
				+ "\"purchaseAmount\": 910,\r\n"
				+ "\"website\": \"www.abc.com\"\r\n"
				+ "},\r\n"
				+ "\"courses\": [\r\n"
				+ "{\r\n"
				+ "\"title\": \"Selenium Python\",\r\n"
				+ "\"price\": 50,\r\n"
				+ "\"copies\": 6\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"Cypress\",\r\n"
				+ "\"price\": 40,\r\n"
				+ "\"copies\": 4\r\n"
				+ "},\r\n"
				+ "{\r\n"
				+ "\"title\": \"RPA\",\r\n"
				+ "\"price\": 45,\r\n"
				+ "\"copies\": 10\r\n"
				+ "}\r\n"
				+ "]\r\n"
				+ "}\r\n"
				+ "";

		
	 // 2)fetch data  by using json class	
		 JsonPath jp =new JsonPath(json);    
         String webvalue = jp.getString("dashboard.website");
         System.out.println(webvalue);        // fetcing complex json 
       
         int coursesize = jp.getInt("courses.size()");
         System.out.println(coursesize);      // fetching complex json 
     //--------------------------------------------
         int sum = 0;
         for(int i=0; i<coursesize; i++)
       {
    	  int copy = jp.getInt("courses["+i+"].copies");
    	  int price = jp.getInt("courses["+i+"].price");
    	          int num = copy*price;
    	          sum=sum+num;
       }
         System.out.println(sum);
      //-------------------------------------------------------
         //Apply assertion 
         int amount = jp.getInt("dashboard.purchaseAmount");
         Assert.assertEquals(sum, amount);
         
         System.out.println(" ------------------------------------");
         
         String titilevalue = jp.getString("courses[1].title");
         System.out.println(titilevalue);      // fetching complex json 
	} }


