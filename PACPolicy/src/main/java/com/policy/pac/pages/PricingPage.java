package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class PricingPage extends Testbase{

	@FindBy(xpath=".//div[//label[text()='Total Charge']]/following-sibling::div//a[span[text()='Issue']]")
	@CacheLookup
	WebElement btnissue;
	
	
	public TransactPage clickissueonPaymentDetails()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btnissue);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		return new TransactPage();
	}
	
	
	public PricingPage() {
		PageFactory.initElements(driver, this);
	}
	
}
