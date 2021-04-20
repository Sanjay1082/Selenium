package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class CoveragePage extends Testbase{

	
	@FindBy(xpath=".//div[//h2[text()='Included Coverages']]/following-sibling::div[@id='next']//a")
	@CacheLookup
	WebElement btnnext;
	
	public EducatioRiskManagementPage clicknextOnCoveragePage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btnnext);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		return new EducatioRiskManagementPage();
	}
	
	public CoveragePage() {
		PageFactory.initElements(driver, this);
	}
}
