package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class ApplicantPage extends Testbase{
	
	@FindBy(xpath =".//div[h2[text()='Applicant Information']]/child::div//a[contains(@id,'anchorId')]")
	@CacheLookup
	WebElement btnimportparty;
	
	@FindBy(xpath =".//input[@fieldref='SD_PartyInput.PartyName']")
	@CacheLookup
	WebElement txtsearchparty;
	
	@FindBy(xpath=".//*[@fieldref='AccountInput.Name']")
	@CacheLookup
	WebElement txtapplicantname;
	
	@FindBy(xpath=".//div[@id='body' and //h2[text()='Billing Address']]/following-sibling::div//a")
	@CacheLookup
	WebElement btnnext;
	
	public PartySearchPage clickonimportparty() throws Exception {
		
		//btnimportparty.click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btnimportparty);
		
		//Actions builder = new Actions(driver);   
		//builder.moveToElement(btnimportparty).click().build().perform();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		driver.switchTo().frame(driver.findElement(By.xpath(".//iframe[contains(@id,'dctPopup_dctPopupWindow')]")));
		return new PartySearchPage();
	}
	
	public String getapplicantname()
	{
		return txtapplicantname.getText();
	}
	
	public PolicyPage clicknextonapplicant() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btnnext);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		
		return new PolicyPage();
	}
	
	public ApplicantPage()
	{
		PageFactory.initElements(driver, this);
	}

}
