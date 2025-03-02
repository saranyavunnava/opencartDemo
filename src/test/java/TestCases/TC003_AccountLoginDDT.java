package TestCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;
import Utilities.DataProviders;

public class TC003_AccountLoginDDT extends BaseClass {

	
	@Test(groups={"sanity"},dataProvider = "LoginData", dataProviderClass = DataProviders.class)
	public void accountLoginDD(String email, String pwd, String exp) {
		try {
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		logger.info("Starting verify login test case.......");
		homePage.clickLogin();
		LoginPage login = new LoginPage(driver);
		login.setUserName(email);
		login.setPassword(pwd);
		login.clickLogin();
		MyAccountPage account = new MyAccountPage(driver);
		if (exp.equalsIgnoreCase("valid")) {
			boolean trgpage = account.verifyMsg();
			if (trgpage == true) {
				account.clickLogout();
				Assert.assertTrue(true);
				
			} else {

				Assert.assertTrue(false);
			}
		}
		if (exp.equalsIgnoreCase("invalid")) {
			boolean trgpage = account.verifyMsg();
			if (trgpage == true) {
				account.clickLogout();
				Assert.assertTrue(false);

			} else {

				Assert.assertTrue(true);
			}
		}
		}
		catch (Exception e) {
			Assert.fail();
		}
		logger.info("End of the login test case..");
	}
	
	@Test(groups={"sanity"})
	public void clickMyAccountLink() {
		
		logger.info("Starting verify links test case.......");
		HomePage homePage = new HomePage(driver);
		homePage.clickMyAccount();
		homePage.clickLogin();
		LoginPage login = new LoginPage(driver);
		login.setUserName(prop.getProperty("userName"));
		login.setPassword(prop.getProperty("password"));
		login.clickLogin();
		MyAccountPage account=new MyAccountPage(driver);
		//Assert.assertTrue(account.clickMyAccountLink(), "My Account link is not displayed");
		boolean lnkDisplayed=account.clickMyAccountLink();
		if(!lnkDisplayed) {
			logger.info("my account link in My Account page is not displayed");
			Assert.fail("Test case failed");
		}
		else {
			logger.info("test case passed as link is displayed");
			Assert.assertTrue(true);	}
		logger.info("test execution completed");
	}
	
}
