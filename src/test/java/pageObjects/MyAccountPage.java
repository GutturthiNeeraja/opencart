package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyAccountPage {
	
WebDriver driver;
	
	//Constructor
	
	public MyAccountPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	//Locating elements
	
		By heading = By.xpath("//h2[text()='My Account']");
		By logout = By.xpath("//a[@class='list-group-item'][text()='Logout']");
		
	//Action methods
		
		public boolean isMyAccountpageExists()
		{
			try
			{
			return (driver.findElement(heading).isDisplayed());
			} 
			catch (Exception e)
			{
				return(false);
			}
		}
		
		public void clickLogout() 
		{
			driver.findElement(logout).click();
		}
		

}
