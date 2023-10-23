package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;
import utilities.DataProviders;
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class LoginTest extends TestBase{
	
	@Test(groups= {"Sanity", "Master"}, dataProvider = "LoginCredentials", dataProviderClass = DataProviders.class)
	public void Login(String email, String pwd)
	{
		logger.info("******* Staring AccountRegistrationTest ******");		
		logger.trace("capturing tracing logs.....");
		logger.debug("capturing debug logs.......");
		
		try
		{
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		logger.info("Clicked on My account");
		
		hp.clickLogin();
		logger.info("Clicked on Resister");
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		logger.info("Provided username and password");
		
		lp.clickLogin();
		logger.info("Clicked on Login button");
		String title = lp.verifyTitle();
		Assert.assertEquals(title, "My Account");
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	}

}
