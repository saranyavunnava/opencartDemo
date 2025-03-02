package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import PageObjects.CheckoutPage;
import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC005_CheckoutFunctionalityValidation extends BaseClass{

	@Test(groups= {"test"})
	public void checkOutItems() {
		logger.info("Verifying checkout functionality....");
		HomePage home=new HomePage(driver);
		home.clickCheckoutLink();
		logger.info("checkout link from homepage is clicked....");
		CheckoutPage chkout=new CheckoutPage(driver);
		try {
			chkout.getCartTotal();
			chkout.clickCouponSection();
			assertTrue(true,"Items available in cart...");
		} catch (Exception e) {
			assertTrue(false);
			e.printStackTrace();
		}
		
	}
}
