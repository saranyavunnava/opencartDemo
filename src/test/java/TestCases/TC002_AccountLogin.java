package TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class TC002_AccountLogin extends BaseClass{

	@Test(groups={"smoke","regression"})
	public void verifyLogin() {
		try {
		HomePage homePage = new HomePage(BaseClass.getDriver());
		homePage.clickMyAccount();
		logger.info("Starting verify login test case.......");
		homePage.clickLogin();
		LoginPage login=new LoginPage(BaseClass.getDriver());
		login.setUserName(prop.getProperty("userName"));
		login.setPassword(prop.getProperty("password"));
		login.clickLogin();
		MyAccountPage account=new MyAccountPage(BaseClass.getDriver());
		if(account!=null) {
			Assert.assertTrue(account.verifyMsg(), "Account page is displayed...");
			account.clickLogout();
			}}
		catch(Exception e) {
			Assert.fail();
		}
			logger.info("compelted executing Verify login page");
	}
}
