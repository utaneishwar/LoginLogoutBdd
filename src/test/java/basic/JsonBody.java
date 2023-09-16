package basic;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
public class JsonBody 
{

	@Test
	public static String getbody()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		String body = 
				("{\\r\\n\"\r\n"
						+ "				+ \"  \\\"id\\\": 0,\\r\\n\"\r\n"
						+ "				+ \"  \\\"username\\\": \\\"kishorutane\\\",\\r\\n\"\r\n"
						+ "				+ \"  \\\"firstName\\\": \\\"kishor\\\",\\r\\n\"\r\n"
						+ "				+ \"  \\\"lastName\\\": \\\"utane\\\",\\r\\n\"\r\n"
						+ "				+ \"  \\\"email\\\": \\\"ku@gmail.com\\\",\\r\\n\"\r\n"
						+ "				+ \"  \\\"password\\\": \\\"kiss@1234\\\",\\r\\n\"\r\n"
						+ "				+ \"  \\\"phone\\\": \\\"8750888818\\\",\\r\\n\"\r\n"
						+ "				+ \"  \\\"userStatus\\\": 0\\r\\n\"\r\n"
						+ "				+ \"}");
		return body;

	}
}
