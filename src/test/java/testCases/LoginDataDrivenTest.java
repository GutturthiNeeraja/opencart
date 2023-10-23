package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.TestBase;
import utilities.DataProviders;

public class LoginDataDrivenTest extends TestBase{
	
	@Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void test_LoginDDT(String email, String pwd, String exp) {
		logger.info(" Starting LoginDataDrivenTest ");
		
	try {
		HomePage hp = new HomePage(driver);
		hp.clickMyAccount();
		hp.clickLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(email);
		lp.setPassword(pwd);
		lp.clickLogin();
		
		MyAccountPage mypage = new MyAccountPage(driver);
		boolean targetpage = mypage.isMyAccountpageExists();
		
		if (exp.equals("Valid")) {
			if (targetpage == true) {
				mypage.clickLogout();
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}
		}

		if (exp.equals("Invalid")) {
			if (targetpage == true) {
				mypage.clickLogout();
				Assert.assertTrue(false);
			} else {
				Assert.assertTrue(true);
			}
		}
	} catch (Exception e) {
		Assert.fail();
	}

	logger.info("Finished LoginDataDrivenTest");		
}
}
