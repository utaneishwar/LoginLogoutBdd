package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage
{
	 WebDriver driver ;
	 
	@FindBy(xpath="//*[@id='userEmail']")
	WebElement username;

	@FindBy(xpath="//*[@id='userPassword']")
	WebElement Password;

	@FindBy(xpath="//*[@id='login']")
	WebElement login;

	@FindBy(xpath="//*[@class='fa fa-sign-out']")
	WebElement signout;
	@FindBy(xpath="(//*[@class='btn w-10 rounded'])[1]")
	WebElement addcart;
	@FindBy(xpath="(//*[@class='fa fa-shopping-cart'])[1]")
	WebElement cart;

	public LoginPage(WebDriver driver)
	{
		 this.driver=driver;
		 PageFactory.initElements(driver,this);
	}
	
	public void userAndPass(String un, String Pwd)
	{
		
		username.sendKeys(un);
		Password.sendKeys(Pwd);
	}
	
	public void submit()
	{
		login.click();
	}
	public void addcart() throws InterruptedException
	{	Thread.sleep(3000);
		 addcart.click();
	}
	public void cart() throws InterruptedException
	{	Thread.sleep(3000);
		cart.click();
	}
	
	
	
	
	public void exit() throws InterruptedException
	{	Thread.sleep(3000);
		 signout.click();
	}

}
