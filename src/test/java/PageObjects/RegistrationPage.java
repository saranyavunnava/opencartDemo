package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

	public RegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "(//input[@id='input-firstname'])")
	WebElement txtFirstName;
	@FindBy(id = "input-lastname")
	WebElement txtLastName;
	@FindBy(id = "input-email")
	WebElement txtEmail;
	@FindBy(id = "input-telephone")
	WebElement txtPhoneNum;
	@FindBy(id = "input-password")
	WebElement txtPassword;
	@FindBy(id = "input-confirm")
	WebElement txtconfirmPassword;
	@FindBy(xpath = "//input[@name='newsletter' and @value='0']")
	WebElement btnNewsLetter;
	@FindBy(xpath = "//input[@name='agree']")
	WebElement chkPolicy;
	@FindBy(xpath = "//input[@type='submit']")
	WebElement btnContinue;
	@FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
	WebElement successMsg;

	public void setFirstName(String firstName) {
		System.out.println(firstName);
		txtFirstName.sendKeys(firstName);
	}

	public void setLastName(String lastName) {
		txtLastName.sendKeys(lastName);
	}

	public void setEmail(String email) {
		txtEmail.sendKeys(email);
	}

	public void setTelephone(String num) {
		txtPhoneNum.sendKeys(num);
	}

	public void setPassword(String password) throws InterruptedException {
		txtPassword.sendKeys(password);
		Thread.sleep(1000);
		/*
		 * Actions action = new Actions(driver); action.sendKeys(Keys.END).perform();
		 */
	}

	public void setConfirmPwd(String password) {
		txtconfirmPassword.sendKeys(password);
	}

	public void clickNewsLetter() {
		// Actions actions = new Actions(driver);
		// actions.moveToElement(btnNewsLetter).click().perform();
		btnNewsLetter.click();
	}

	public void setprivacyPolicy() throws InterruptedException {
		/*
		 * Actions actions = new Actions(driver);
		 * actions.moveToElement(chkPolicy).click().perform(); //
		 */
		chkPolicy.click();
	}

	public void clickContinue() {
		btnContinue.click();
	}

	public String checkConfirmMsg() {
		try {
			System.out.println(successMsg.getText());
			return successMsg.getText();
		} catch (Exception e) {
			return e.getMessage();
		}
	}

}
