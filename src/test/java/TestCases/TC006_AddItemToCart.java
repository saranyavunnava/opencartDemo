package TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.util.Assert;

import PageObjects.HomePage;
import PageObjects.LoginPage;
import PageObjects.MyAccountPage;
import TestBase.BaseClass;

public class TC006_AddItemToCart extends BaseClass {
	@Test(groups= {"test"})
	public void addItem() {
		logger.info("Verifying Adding item to cart functionality....");
		HomePage home=new HomePage(BaseClass.getDriver());
		logger.info("User is logged to the application....");
		home.clickMyAccount();
		home.clickLogin();
		LoginPage login=new LoginPage(BaseClass.getDriver());
		login.setUserName(prop.getProperty("userName"));
		login.setPassword(prop.getProperty("password"));
		login.clickLogin();
		MyAccountPage account=new MyAccountPage(BaseClass.getDriver());
		account.addItem();
		account.clickAddToCartBtn();
		org.testng.Assert.assertEquals(account.verifyAddItemSuccessMsg(), "Success: You have added");
		
		
		
	
}
}
