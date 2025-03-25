package TestCases;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import TestBase.BaseClass;

public class TC004_SearchByItem extends BaseClass {
	@Test(groups= {"sanity"})
	public void searchItem() {
		HomePage home=new HomePage(BaseClass.getDriver());
		home.enterSearchCriteria(prop.getProperty("searchItem"));
		logger.info("search item entered");
		if(home.clickSearch()) {
		Assert.assertTrue(true,"search is not clickable");}
		else {
			Assert.assertFalse(false);
		Assert.fail();
		}
			
	}

}
