package pages;

import java.time.Duration;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NoncommerceHome 
{
	WebDriverWait wait ;
	WebDriver driver;
	@FindBy (xpath="//*[@id='Email']")
	WebElement email;
	@FindBy (xpath="//*[@id='Password']")
	WebElement password;
    @FindBy (xpath="//*[text()='Log in']")
	WebElement login;
    
	@FindBy(xpath = "(//*[text()='Computers '])[1]")
	WebElement Computer;
	@FindBy(xpath = "(//*[text()='Desktops '])[3]")
	WebElement Desktop;
	@FindBy(xpath = "(//*[text()='Add to cart'])[1]")
	WebElement Enterpriser;
	@FindBy(xpath = "//*[@id='product_attribute_2']")
	WebElement RAM;
	@FindBy(xpath = "//*[@id='product_attribute_3_6']")
	WebElement HDD;
	@FindBy(xpath = "//*[text()='Add to cart']")
	WebElement AddShoppingCart;

	public NoncommerceHome(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void credential(String username, String pass)
	{   
		email.sendKeys(username);
		password.sendKeys(pass);
	}
	public void Login()
	{   
		 login.click();
	}

	public void computer()
	{   
		Computer.click();
	}
	public void desktop() throws InterruptedException
	{	Thread.sleep(2000);
	   Desktop.click();
	}
	public void enterprizer() throws InterruptedException 
	{
		Actions act =new Actions(driver);
		act.scrollByAmount(0, 500).perform();
//		wait=new WebDriverWait(driver, Duration.ofSeconds(60));
//		wait.until(ExpectedConditions.elementToBeClickable(Enterpriser));
//		  
          Thread.sleep(2000);
	     Enterpriser.click();
		
	}
	public void RamAndHDD() throws InterruptedException
	{
		
		Thread.sleep(2000);
		Actions act = new Actions(driver);
		act.scrollByAmount(500, 0);
	    Thread.sleep(2000);
		
		Select sel =new Select(RAM);
		     RAM.click();
		act.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
		HDD.click();
		
	}
	public void AddProduct()
	{
		AddShoppingCart.click();
	}


}
