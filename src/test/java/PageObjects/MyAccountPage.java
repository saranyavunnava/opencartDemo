package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class MyAccountPage extends BasePage {

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//h2[text()='My Account']")
	WebElement msgHeading;

	@FindBy(xpath = "//a[text()='Logout' and @class='list-group-item']")
	WebElement lnkLogout;
	
	@FindBy(xpath = "//a[@class='list-group-item' and text()='My Account']")
	WebElement lnkMyAccount;
	

	public boolean verifyMsg() {
		try {
			return msgHeading.isDisplayed();
		} catch (Exception e) {
			return false;
		}
	}
		public void clickLogout() {
			lnkLogout.click();
		}
		
		public boolean clickMyAccountLink() {
			try {
				lnkMyAccount.isDisplayed();
				lnkMyAccount.click();
			}
			catch (Exception e) {
				return false;
			}
			return true;
		}
	}

