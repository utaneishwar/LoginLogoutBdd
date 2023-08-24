package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions
( 
		features="src\\test\\resources\\featureFile\\loginlogout.feature",
		glue="execution",
		plugin = "pretty",
		publish =true
		
		
)

public class Runner extends AbstractTestNGCucumberTests
{

}
