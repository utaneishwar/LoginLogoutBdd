package fetchDataFromResponse;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class FetchDetailsFromReadyMadeJson 
{
	@Test
	public void fetchdata()
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


		JsonPath jp = new JsonPath(json);
		String webvalue = jp.getString("dashboard.website");
		System.out.println(webvalue);

		// print the no of courses return by API	
		int totalcourses = jp.getInt("courses.size()");
		System.out.println(totalcourses);   // 3
		System.out.println("---------------------------");
		// print purchase amount

		int purchasevalue = jp.getInt("dashboard.purchaseAmount");
		System.out.println(purchasevalue);   // 910
		System.out.println("---------------------------");
		// print title of the first course
		String firstcoursetitle = jp.getString("courses[0].title");
		System.out.println(firstcoursetitle);    // Selenium Python
		System.out.println("---------------------------");

		//print all courses title and respective their prices
		int sizevalue = jp.getInt("courses.size()");
		for(int i=0; i<sizevalue; i++ )
		{
			String title = jp.getString("courses["+i+"].title");
			System.out.println(title);
			int pricesvalue=jp.getInt("courses["+i+"].price");
			System.out.println(pricesvalue);
		}
		System.out.println("---------------------------");
		//print no of copies sold by RPA course


		for(int i=0; i<sizevalue; i++)
		{
			String title = jp.getString("courses["+i+"].title");
			if(title.equals("RPA"))
			{
				int copiesvalue = jp.getInt("courses["+i+"].copies");
				System.out.println(copiesvalue);    // 10
			}

		}
		System.out.println("---------------------------");
		
	


	}

}
