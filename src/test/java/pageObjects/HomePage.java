package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
WebDriver driver;
	
	//Constructor

	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locating elements using Page Factory
	
	@FindBy(xpath = "//span[text()='My Account']")
	WebElement MyAccount;
	
	@FindBy(xpath = "//a[text()='Register']")
	WebElement Register;
	
	@FindBy(xpath = "//a[text()='Login']")
	WebElement Login;
	
	//Action methods
	
	public void clickMyAccount()
	{
		MyAccount.click();
	}
	
	public void clickRegister()
	{
		Register.click();
	}
	
	public void clickLogin()
	{
		Login.click();
	}

}
