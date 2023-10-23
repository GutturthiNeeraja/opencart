package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountRegistration {
	
	WebDriver driver;
	
	//Constructor
	
	public AccountRegistration(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Locating elements using Page Factory
	
	@FindBy(xpath = "//input[@id='input-firstname']")
	WebElement firstname;
	
	@FindBy(xpath = "//input[@id='input-lastname']")
	WebElement lastname;
	
	@FindBy(xpath = "//input[@id='input-email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='input-telephone']")
	WebElement telephone;
	
	@FindBy(xpath = "//input[@id='input-password']")
	WebElement password;
	
	@FindBy(xpath = "//input[@id='input-confirm']")
	WebElement confirmpassword;
	
	@FindBy(xpath = "//input[@name='agree']")
	WebElement Policy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	WebElement Continue;
	
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement msgConfirmation;
	
	//Action methods
	
	public void setFirstName(String fname)
	{
		firstname.sendKeys(fname);
	}
	
	public void setLastName(String lname)
	{
		lastname.sendKeys(lname);
	}
	
	public void setEmail(String Email)
	{
		email.sendKeys(Email);
	}
	
	public void setTelephone(String tel)
	{
		telephone.sendKeys(tel);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void setConfirmPassword(String pwd)
	{
		confirmpassword.sendKeys(pwd);
	}
	
	public void setPrivatePolicy()
	{
		Policy.click();
	}
	
	public void clickContinue()
	{
		//sol1 
		Continue.click();
		
		//sol2 
		//Continue.submit();
		
		//sol3
		//Actions act=new Actions(driver);
		//act.moveToElement(Continue).click().perform();
					
		//sol4
		//JavascriptExecutor js=(JavascriptExecutor)driver;
		//js.executeScript("arguments[0].click();", Continue);
		
		//Sol 5
		//Continue.sendKeys(Keys.RETURN);
		
		//Sol6  
		//WebDriverWait mywait = new WebDriverWait(driver, Duration.ofSeconds(10));
		//mywait.until(ExpectedConditions.elementToBeClickable(Continue)).click();
	}
	
	public String getConfirmationMsg() 
	{
		try 
		{
			return (msgConfirmation.getText());
		} 
		catch (Exception e) 
		{
			return (e.getMessage());
		}
     
}
}
