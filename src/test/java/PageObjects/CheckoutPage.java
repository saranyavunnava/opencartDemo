package PageObjects;

import static org.testng.Assert.assertTrue;

import java.awt.geom.IllegalPathStateException;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.OptionalInt;

import javax.management.RuntimeErrorException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;

import TestBase.BaseClass;

public class CheckoutPage extends BasePage {

	public CheckoutPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(id = "cart-total")
	WebElement itemsTotal;

	@FindBy(xpath = "//table[@class='table table-bordered']//parent::div[@class='table-responsive']")
	WebElement cartItemsList;
	
	@FindBy(xpath = "//a[text()='Use Coupon Code ']//i[contains(@class,'fa-caret-down')]")
	WebElement couponCaret;
 public void getCartTotal() throws Exception {
		try {
		String total=itemsTotal.getText();
	Optional<String> cartTotal=	Arrays.stream(total.split("-")).skip(1).findFirst();
		System.out.println("cart total is .."+cartTotal);
	}catch (Exception e) {
		throw new Exception("Cart is empty..");
	}}
	public void verifyItemsinCart() {
		if(cartItemsList.isDisplayed()) {
			//div[@id='content']
	}
	}
		public void clickCouponSection() {
			try {
			if(couponCaret.isEnabled() && couponCaret.isDisplayed()) {
				couponCaret.click();
			}}
			catch (Exception e) {
				throw new NoSuchElementException("coupon section is not available...");
			}
		}
}
