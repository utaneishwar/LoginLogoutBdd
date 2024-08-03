package may14Restpractice;

import io.restassured.RestAssured;

public class JsonBody 
{
	public static String redimadeJsonBody()
	{
		String jsonnbody="{\r\n"
							+ "  \"id\": 0,\r\n"
							+ "  \"username\": \"testuser\",\r\n"
							+ "  \"firstName\": \"Test\",\r\n"
							+ "  \"lastName\": \"User\",\r\n"
							+ "  \"email\": \"testuser@abc.com\",\r\n"
							+ "  \"password\": \"Test@1234\",\r\n"
							+ "  \"phone\": \"7894561230\",\r\n"
							+ "  \"userStatus\": 0\r\n"
							+ "}";
		return jsonnbody;   
	}

	public static void main(String[] args) 
	{
		
	}

}
