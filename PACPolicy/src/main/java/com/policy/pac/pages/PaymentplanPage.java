package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class PaymentplanPage extends Testbase{

	@FindBy(xpath=".//div[//label[text()='Cash With Transaction']]/following-sibling::div//a[span[text()='Previous']]")
	@CacheLookup
	WebElement btnprevious;
	
	@FindBy(xpath=".//input[@fieldref='BillingKeys.BillClass']")
	@CacheLookup
	WebElement txtpaymentplan;
	
	public PricingPage clickpreviousonPaymentDetails()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btnprevious);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		return new PricingPage();
	}
	
	public void selectPaymentPlan(String value)
	{
		txtpaymentplan.clear();
		txtpaymentplan.sendKeys(value);
		txtpaymentplan.sendKeys(Keys.TAB);
	}
	
	public PaymentplanPage() {
		PageFactory.initElements(driver, this);
	}
	
}
