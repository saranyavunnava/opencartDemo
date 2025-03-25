package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
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

	@FindBy(xpath = "//ul[@class='list-unstyled']//li[normalize-space()='Mac (1)']")
	WebElement searchItem;

	@FindBy(xpath = "//span[text()='Add to Cart']")
	WebElement addToCartBtn;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement succMsg;

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
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void addItem() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[normalize-space()='Desktops']"))).perform();
		searchItem.click();
	}

	public void clickAddToCartBtn() {
		addToCartBtn.click();
	}

	public String verifyAddItemSuccessMsg() {
		System.out.println("success message....."+succMsg.getText());
		return succMsg.getText();

	}
}
