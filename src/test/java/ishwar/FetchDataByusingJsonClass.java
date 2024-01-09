package ishwar;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class FetchDataByusingJsonClass 
{
	
	// this is another way to fetch the data from redimade json ;
	JsonPath jp =new JsonPath(RedimadeJson.jsonbody());

	@Test
	public void usercreate()
	{
		// // 300+160+450=910

		// 
		
		int pa = jp.getInt("dashboard.purchaseAmount");
		System.out.println(pa);

		int sum=0;

		for(int i=0; i<jp.getInt("courses.size()"); i++)
		{
			int price = jp.getInt("courses["+i+"].price");
			int copies = jp.getInt("courses["+i+"].copies");

			int pc = price*copies;

			sum=sum+pc;  // 910
		}
		System.out.println(sum);  
		Assert.assertEquals(pa, sum); 

	}
	@Test(priority=2)
	public void checkcopiesofcypress()
	{

		for(int i=0; i<jp.getInt("courses.size()"); i++)
		{
		 String titleofcoursess = jp.getString("courses["+i+"].title");
			 System.out.print(titleofcoursess+" ,");
			if(titleofcoursess.equals("Cypress"))
			{
				int copiesofcypress = jp.getInt("courses["+i+"].copies");
				System.out.println(copiesofcypress);
			}

		}
		 String Website = jp.getString("dashboard.website");
		 System.out.println(Website);
	}
	
	
	
	
	
	
}
