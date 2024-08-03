package book_store_api;

public class RequestBodyBookStore extends CommanData
{

	

	public static String RequestBody()
	{
//		String un = UN;
//		String pw=PW;

		String body = "{\r\n"
				+ "  \"userName\": \""+UN+"\",\r\n"
				+ "  \"password\": \""+PW+"\"\r\n"
				+ "}";

		return body;

	}
	public static void main(String[] args) {
		RequestBody();
	}
}
