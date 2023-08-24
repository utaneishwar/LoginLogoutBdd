package execution;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.NoncommerceHome;
import qa.DriverFactory;

public class noncommerceStep 
{
	WebDriver driver;
	
	NoncommerceHome nc =new NoncommerceHome(DriverFactory.getdriver());

	@Given("user should be on nop commerce")
	public void user_should_be_on_nop_commerce() {
		 driver =DriverFactory.getdriver();
		driver.get("https://demo.nopcommerce.com/login");
	}

	@Given("user provide credential as {string} and {string}")
	public void user_provide_credential_as_and(String string, String string2) {
		 nc.credential(string, string2);
	}

	@Given("user click on log in button")
	public void user_click_on_log_in_button() {
		nc.Login();
	}

	@Given("user should be on nop commerce Homepage")
	public void user_should_be_on_nop_commerce_homepage() {
	   System.out.println("user should be on Homepaghe");
	}

	@When("user click on computer categories")
	public void user_click_on_computer_categories()  {
		nc.computer();
	}

	@When("user click on desktop")
	public void user_click_on_desktop() throws InterruptedException {
		nc.desktop();
	}

	@When("user click on enterprizer add to cart desktop product")
	public void user_click_on_perticular_desktop_product() throws InterruptedException {
		
		nc.enterprizer();
	}

	@Then("user seen build your own computer")
	public void user_should_seen_desktops() {
		System.out.println("user see the desktp product");
	}

	@Given("user should on computer desktop page")
	public void user_should_on_computer_desktop_page() {
		System.out.println("user on the desktop product page");
	}

	@When("user select Ram and HDD")
	public void user_select_ram_and_hdd() throws InterruptedException {
		nc.RamAndHDD();
	}

	@When("user click on Add to cart")
	public void user_click_on_add_to_cart() {
		nc.AddProduct();
	}

	@Then("desktop Should Added into the shopping cart")
	public void desktop_should_added_into_the_shopping_cart() {
		System.out.println("Added desktop into the shopping cart");
	}

}
