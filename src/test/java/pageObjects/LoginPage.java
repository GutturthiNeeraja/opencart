package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	WebDriver driver;
	
	//Constructor
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locating elements
	
	By email = By.xpath("//input[@id='input-email']");
	By password = By.xpath("//input[@id='input-password']");
	By Login = By.xpath("//input[@value='Login']");
	By Title = By.xpath("//h2[text()='My Account']");
    
    //Action methods
    public void setEmail(String Email)
    {
    	driver.findElement(email).sendKeys(Email);
    }
    
    public void setPassword(String pwd)
    {
    	driver.findElement(password).sendKeys(pwd);
    }
    
    public void clickLogin()
    {
    	driver.findElement(Login).click();
    }
    
    public String verifyTitle()
    {
    	try
    	{
    	return(driver.findElement(Title).getText());
        }
    	catch(Exception e)
    	{
    		return(e.getMessage());
    	}
    	
    }  
}
