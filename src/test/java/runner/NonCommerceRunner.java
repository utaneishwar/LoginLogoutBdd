package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions 
(	
	features ={"src\\test\\resources\\featureFile\\nopcommerce.feature"},
	glue= {"execution"},
	plugin = {"pretty"}
)

public class NonCommerceRunner extends AbstractTestNGCucumberTests 
{
	
}
