package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//span[normalize-space()='My Account']")
	WebElement lnkMyAccount;
	@FindBy(xpath = "//a[normalize-space()='Register']")
	WebElement lnkregister;
	@FindBy(xpath = "//li//a[normalize-space()='Login']")
	WebElement lnkLogin;
	@FindBy(xpath = "//input[@name='search']")
	WebElement txtboxSearch;
	@FindBy(className = "input-group-btn")
	WebElement searchIcon;
	@FindBy(xpath = "//span[text()='Checkout']")
	WebElement lnkCheckOut;
	

	public void clickMyAccount() {
		lnkMyAccount.click();
	}

	public void clickRegisterLink() {
		lnkregister.click();
	}

	public void clickLogin() {
		lnkLogin.click();
	}

	public void enterSearchCriteria(String item) {
		txtboxSearch.sendKeys(item);
	}

	public boolean clickSearch() {
		try {
			searchIcon.click();
		} catch (Exception e) {
			return false;
		}
		return true;

	}
	public boolean clickCheckoutLink() {
		if(lnkCheckOut.isDisplayed()) {
			lnkCheckOut.click();
			return true;
		}
		else 
		return false;
	}
}