package petanimal;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import petpojo.Category;
import petpojo.Tags;

public class Response_PetAnimals_With_Status
{
	@Test
	public void Get_status_of_animals()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2/";
		Pojo_of_petanimals[] response = given()
										.header("accept","application/json")
										.when()
										.get("/pet/findByStatus?status=sold")
										.then()
										.extract()
										.response()
										//.asString();
										.as(Pojo_of_petanimals[].class);
	
		for(Pojo_of_petanimals responses:response)
		{
		
//			System.out.print("ID IS: "+responses.getId()+"   Name IS: "+responses.getName());
//			System.out.println();
//
//			try {
//				System.out.println(responses.getPhotoUrls()[0].toString());
//			} catch (ArrayIndexOutOfBoundsException e) {
//				System.out.println("message is: "+e.getMessage());
//			}
			
			System.out.println("status are: "+responses.getStatus().toString());;
			if(responses.getName().toString().equals("doggie"))
			{
				System.out.println("Tag ID IS: "+responses.getTags().get(0).getId().toString()+" Id of Toto: "+responses.getId().toString()+"  Tag Name IS: "+responses.getTags().get(0).getName().toString());
				System.out.println(responses.getPhotoUrls()[0].toString());
			}
			else if(responses.getId().toString().equals("152966"))
			{
				System.out.println(responses.getName().toString()); //puppy2
			}
			else
			{
				continue;
			}


		}


		//		for(int i=0; i<response.length; i++)
		//		{
		//			Pojo_of_petanimals arrdata = response[i];
		//			System.out.println(arrdata.toString());
		//			 List<Tags> url = response[i].getTags();
		//			String nameoftag = url.get(i).getName();
		//			System.out.println(nameoftag );
		//			
		//		}

		//System.out.println(category);
		//
		//		System.out.println("get-animal details based on status ");
		//		String status = response.getStatus();
		//		System.out.println(status);
		//		
		//		String id = response.getId();
		//		System.out.println(response.getStatus());
	}
}
