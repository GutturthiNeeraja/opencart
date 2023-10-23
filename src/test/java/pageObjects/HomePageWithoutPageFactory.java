package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageWithoutPageFactory {
	
	WebDriver driver;
	
	//Constructor
	
	public HomePageWithoutPageFactory(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locating elements without Page Factory
	
	By MyAccount = By.xpath("//span[text()='My Account']");
	By Register = By.xpath("//a[text()='Register']");
	By Login = By.xpath("//a[text()='Login']");
	
	//Action methods
	
	public void clickMyAccount()
	{
		driver.findElement(MyAccount).click();
	}
	
	public void clickRegister()
	{
		driver.findElement(Register).click();
	}
	
	public void clickLogin()
	{
		driver.findElement(Login).click();
	}

}
