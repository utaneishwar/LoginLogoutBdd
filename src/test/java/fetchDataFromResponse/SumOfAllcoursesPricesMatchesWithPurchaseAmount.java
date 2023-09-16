package fetchDataFromResponse;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import junit.framework.Assert;

public class SumOfAllcoursesPricesMatchesWithPurchaseAmount 
{
	@Test
	public void verifyPurchaseAmount()
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

		//	// verify if sum of all course prices matches with purchase amount
		JsonPath jp = new JsonPath(json);
		int sizevalue = jp.getInt("courses.size()");
		System.out.println(sizevalue);
		int sum=0;
		int num=0;
		for(int i=0; i<sizevalue; i++)
		{
			int priceno = jp.getInt("courses["+i+"].price");
			int copiesno = jp.getInt("courses["+i+"].copies");
			sum= priceno*copiesno;   // 50*6=300 , 40*4=160, 45*10=450
			num=num+sum;              // 300+ 160+ 450 =910
		}
		System.out.println(num);
		int value = jp.getInt("dashboard.purchaseAmount");
		Assert.assertEquals(num,value);     //910==910  true.
}
}
