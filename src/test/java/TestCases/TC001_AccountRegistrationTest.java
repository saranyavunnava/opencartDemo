package TestCases;

import java.util.Random;
import java.util.random.RandomGenerator;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObjects.HomePage;
import PageObjects.RegistrationPage;
import TestBase.BaseClass;

public class TC001_AccountRegistrationTest extends BaseClass {

	@Test(groups={"smoke","sanity"})
	public void verifyAccountRegistration() throws InterruptedException {
		logger.info("Starting verifyAccountRegistration test case..... ");

		HomePage homePage = new HomePage(BaseClass.getDriver());
		homePage.clickMyAccount();
		homePage.clickRegisterLink();
		RegistrationPage regPage = new RegistrationPage(BaseClass.getDriver());
		regPage.setFirstName(generateString().toUpperCase());
		regPage.setLastName(generateString().toUpperCase());
		String email = generateString() + "@gmail.com";
		regPage.setEmail(email);
		String number=generateNumber();
		regPage.setTelephone(number);
		String pwd = generateString().toLowerCase();
		regPage.setPassword(pwd);
		regPage.setConfirmPwd(pwd);
		regPage.clickNewsLetter();
		regPage.setprivacyPolicy();
		regPage.clickContinue();
		try {
			String msg = regPage.checkConfirmMsg();
			Assert.assertEquals(msg, "Your Account Has Been Created!");
			
		} catch (Exception e) {
			logger.error(e.getMessage() + "Test failed....");
		}
	}

}
