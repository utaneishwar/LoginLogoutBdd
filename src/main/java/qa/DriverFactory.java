package qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory
{
	static WebDriver driver;
	public WebDriver initbrowser()
	{
		driver=new ChromeDriver();
		return driver;
	}
	
	public static WebDriver getdriver()
	{
		return driver;
	}
	
}
