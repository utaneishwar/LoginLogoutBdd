package execution;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;
import qa.DriverFactory;


public class LoginOutStep
{

	LoginPage lp =new LoginPage(DriverFactory.getdriver());

	@Given("user should be on login page")
	public void user_should_be_on_login_page() {
		WebDriver driver =DriverFactory.getdriver();
		driver.get("https://rahulshettyacademy.com/client");

	}
	@When("user passed credential as {string} and {string}")
	public void user_passed_credential_as_and(String string, String string2) throws InterruptedException
	{
		lp.userAndPass(string, string2);

	}

	@Then("user click on login button")
	public void user_click_on_login_button()
	{
		lp.submit();
	}

	@Given("user should on product page")
	public void user_should_on_product_page() {
		System.out.println("user should on the product page");
	}

	@When("user click on signout button")
	public void user_click_on_signout_button() throws InterruptedException
	{
		lp.exit();
	}

	@Then("user exit from that page")
	public void user_exit_from_that_page() 
	{
		System.out.println("logout from that application");
	}

	@Given("user Should be at product page")
	public void user_should_be_at_product_page() {
			System.out.println("user land on product page");
	}

	@When("user click on add to cart")
	public void user_click_on_add_to_cart() throws InterruptedException {
      lp.addcart();
	}

	@When("user should on cart icon")
	public void user_should_on_cart_icon() throws InterruptedException {
          lp.cart();
	}

	@Then("user should see the product into the my cart")
	public void user_should_see_the_product_into_the_my_cart() {
System.out.println("cart verify");
	}

}
