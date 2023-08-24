package execution;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import qa.DriverFactory;

public class Hooksclass 
{
	WebDriver driver;
	@Before
	public void initbrowser()
	{
		DriverFactory df = new DriverFactory();
		
		 driver = df.initbrowser();
		
		driver.manage().window().maximize();
	}


	@After(order = 2)
	public void tearDown(Scenario scenario)
	{
		if(scenario.isFailed())
		{
			String scenarioname = scenario.getName();
			scenarioname.replace(" ", "_");

			TakesScreenshot ts = (TakesScreenshot)driver;

			byte[] source = ts.getScreenshotAs(OutputType.BYTES);

			scenario.attach(source, "image/png", scenarioname);
		}
	}

	@After (order=1)
	public void quitbrowser()
	{

	}

}
