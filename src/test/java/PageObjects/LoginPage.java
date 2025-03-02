package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	@FindBy(id="input-email")
	WebElement txtEmail;
	@FindBy(id="input-password")
	WebElement txtPwd;
	@FindBy(xpath = "//input[@value='Login']")
	WebElement btnLogin;
	
	public void setUserName(String username) {
		txtEmail.sendKeys(username);
	}
	public void setPassword(String password) {
		txtPwd.sendKeys(password);
	}
	
	public void clickLogin() {
		btnLogin.click();
	}
}
