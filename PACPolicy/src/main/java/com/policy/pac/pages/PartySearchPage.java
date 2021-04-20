package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class PartySearchPage extends Testbase{
	
	@FindBy(xpath =".//*[@fieldref='SD_PartyInput.PartyName']")
	@CacheLookup
	WebElement txtlastname;
	
	@FindBy(className ="g-btn-text")
	@CacheLookup
	WebElement btnsearchforpeopleandplaces;

	@FindBy(xpath=".//a[@id='dctGridLink' and text()='Select']")
	@CacheLookup
	WebElement lnkselect;
	
	public void partysearch(String lastname) throws Exception{
		txtlastname.sendKeys(lastname);
		btnsearchforpeopleandplaces.click();
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
	}
	
	public ApplicantPage selectpartyrecord() throws Exception {
		lnkselect.click();
		Thread.sleep(5000);
		driver.switchTo().defaultContent();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		return new ApplicantPage();
	}
	
	
	public PartySearchPage() {
    PageFactory.initElements(driver, this);
}
}
