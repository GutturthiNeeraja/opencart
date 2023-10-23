package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import testBase.TestBase;
import pageObjects.HomePage;
import pageObjects.AccountRegistration;

public class AccountRegistrationTest extends TestBase{
	
	
	
	@Test(groups= {"Regression", "Master"})
	public void AccountRegistration()
	{
		logger.info("******* Staring AccountRegistrationTest ******");		
		logger.trace("capturing tracing logs.....");
		logger.debug("capturing debug logs.......");
		
		try
		{
		HomePage hp = new HomePage(driver);
		
		hp.clickMyAccount();
		logger.info("Clicked on My account");
		
		hp.clickRegister();
		logger.info("Clicked on Resister");
		
		AccountRegistration regPage = new AccountRegistration(driver);
		regPage.setFirstName(randomString().toUpperCase());
		regPage.setLastName(randomString().toUpperCase());
		regPage.setEmail(randomString()+"@gmail.com");
		regPage.setTelephone(randomNumber());
		
		String password = randomAlphaNumeric();
		regPage.setPassword(password);
		regPage.setConfirmPassword(password);
		
		regPage.setPrivatePolicy();
		logger.info("Provided customer details and agreed private policy");
		
		regPage.clickContinue();
		logger.info("Clicked on Continue button");
		
		String confirmMsg = regPage.getConfirmationMsg();
		if (confirmMsg.equals("Your Account Has Been Created!"))
		{
			logger.info("Test Passed");
			Assert.assertTrue(true);
	    }
		else
		{	
			logger.warn("Customer registration is not successful");
			logger.info("Test Failed");
			Assert.assertTrue(false);
			
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("********* Finished AccountRegistrationTest ******");
	}	

	}
