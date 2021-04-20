package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class EducatioRiskManagementPage extends Testbase{

	@FindBy(xpath=".//div[//div[text()='Risk Management']]/following-sibling::div[@id='next']//a")
	@CacheLookup
	WebElement btnnext;
	
	public ClassDeterminationPage clicknextOnEduandRskPage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btnnext);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		return new ClassDeterminationPage();
	}
	
	public EducatioRiskManagementPage() {
		PageFactory.initElements(driver, this);
	}
}
