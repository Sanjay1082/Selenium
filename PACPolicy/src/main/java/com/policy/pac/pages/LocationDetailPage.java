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

public class LocationDetailPage extends Testbase{

	@FindBy(xpath=".//*[@fieldref='LocationInput.Description']")
	@CacheLookup
	WebElement txtcdescription;
	
	@FindBy(xpath=".//*[@fieldref='LocationInput.Address1']")
	@CacheLookup
	WebElement txtaddressl;
	
	@FindBy(xpath=".//*[@fieldref='LocationInput.Address2']")
	@CacheLookup
	WebElement txtaddress2;
	
	@FindBy(xpath=".//*[@fieldref='LocationInput.Address3']")
	@CacheLookup
	WebElement txtaddress3;
	
	@FindBy(xpath=".//*[@fieldref='LocationInput.Address4']")
	@CacheLookup
	WebElement txtaddress4;
	
	@FindBy(xpath=".//*[@fieldref='LocationInput.ZipCode']")
	@CacheLookup
	WebElement txtzipcode;
	
	@FindBy(xpath=".//*[@fieldref='LocationInput.Territory']")
	@CacheLookup
	WebElement txtterritory;
	
	@FindBy(xpath=".//div[//label[text()='# of Hours Worked']]/following-sibling::div//a[contains(@id,'anchorId')]")
	@CacheLookup
	WebElement btnok;
	
	public void populateDataonLocationPage(String label, String value) throws Exception
	{
		if(label.equalsIgnoreCase("Description"))
		{
			txtcdescription.sendKeys(value);
		}
		else if(label.equalsIgnoreCase("Address 1"))
		{
			txtaddressl.sendKeys(value);
		}
		else if(label.equalsIgnoreCase("Address 2"))
		{
			txtaddress2.sendKeys(value);
		}
		else if(label.equalsIgnoreCase("Address 3"))
		{
			txtaddress3.sendKeys(value);
		}
		else if(label.equalsIgnoreCase("Address 4"))
		{
			txtaddress4.sendKeys(value);
		}
		else if(label.equalsIgnoreCase("Zip Code"))
		{
			txtzipcode.sendKeys(value);
			txtzipcode.sendKeys(Keys.TAB);
			Thread.sleep(3000);	
		}
	}
	
	public String getLocationPageTeXT(String label) {
		
		if(label.equalsIgnoreCase("Description"))
		{
			return txtcdescription.getText();
		}
		else if(label.equalsIgnoreCase("Address 1"))
		{
			return txtaddressl.getText();
		}
		else if(label.equalsIgnoreCase("Address 2"))
		{
			return txtaddress2.getText();
		}
		else if(label.equalsIgnoreCase("Address 3"))
		{
			return txtaddress3.getText();
		}
		else if(label.equalsIgnoreCase("Address 4"))
		{
			return txtaddress4.getText();
		}
		else if(label.equalsIgnoreCase("Zip Code"))
		{
			return txtzipcode.getText();
		}
		else if(label.equalsIgnoreCase("Territory"))
		{
			return txtterritory.getText();
		}
		return null;
	}
	
	public PolicyPage clickokonlocationdeatils() throws Exception
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btnok);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		
		return new PolicyPage();
	}
	
	public LocationDetailPage() {
		PageFactory.initElements(driver, this);
	}
}
