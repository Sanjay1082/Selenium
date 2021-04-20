package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class PolicyPage extends Testbase{
	
	@FindBy(xpath=".//*[@fieldref='PolicyInput.UnderwritingCompany']")
	@CacheLookup
	WebElement txtcompany;
	
	@FindBy(xpath=".//*[@fieldref='AgencyInput.Name']")
	@CacheLookup
	WebElement txtagency;
	
	@FindBy(xpath=".//*[@fieldref='PolicyInput.IssueState']")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(xpath=".//*[@fieldref='PolicyInput.OMSNICPolicyType']")
	@CacheLookup
	WebElement txtpolicytype;
	
	@FindBy(xpath=".//*[@fieldref='PolicyInput.ProductType']")
	@CacheLookup
	WebElement txtproducttype;
	
	@FindBy(xpath=".//*[@fieldref='PolicyOutput.AssignedUnderwriter']")
	@CacheLookup
	WebElement txtunderwriter;
	
	@FindBy(xpath=".//*[@fieldref='PolicyInput.EffectiveDate']")
	@CacheLookup
	WebElement txteffectivedate;
	
	@FindBy(xpath=".//*[@fieldref='PolicyInput.ExpirationDate']")
	@CacheLookup
	WebElement txtexpirationdate;
	
	@FindBy(xpath=".//*[@fieldref='PolicyInput.CoverageType']")
	@CacheLookup
	WebElement txtpolicyform;
	
	@FindBy(xpath=".//*[@fieldref='PolicyInput.RetroDate']")
	@CacheLookup
	WebElement txtretrodate;
	
	@FindBy(xpath=".//div[@id='body' and //h2[text()='Office Locations']]/following-sibling::div//div[@id='next']/a")
	@CacheLookup
	WebElement btnnext;
	
	@FindBy(xpath=".//div[h2[text()='Office Locations']]/following-sibling::div//a[contains(@id,'anchorId')]")
	@CacheLookup
	WebElement btnaddlocation;
	

	public String getPolicyPageText(String label)
	{
		if(label.equalsIgnoreCase("company"))
		{
			return txtcompany.getText();
		}
		else if(label.equalsIgnoreCase("agency"))
		{
			return txtagency.getText();	
		}
		else if(label.equalsIgnoreCase("state"))
		{
			return txtstate.getText();	
		}
		else if(label.equalsIgnoreCase("Policy type"))
		{
			return txtpolicytype.getText();	
		}
		else if(label.equalsIgnoreCase("product type"))
		{
			return txtproducttype.getText();	
		}
		else if(label.equalsIgnoreCase("Underwriter"))
		{
			return txtunderwriter.getText();	
		}
		else if(label.equalsIgnoreCase("Policy Effective Date"))
		{
			return txteffectivedate.getText();	
		}		
		else if(label.equalsIgnoreCase("Policy Expiration Date"))
		{
			return txtexpirationdate.getText();	
		}
		else if(label.equalsIgnoreCase("Policy Forms"))
		{
			return txtpolicyform.getText();	
		}
		else if(label.equalsIgnoreCase("Retroactive Date"))
		{
			return txtretrodate.getText();	
		}
		return null;
	}
	
	
	public void populateDataonPolicyPage(String label, String data)
	{
		if(label.equalsIgnoreCase("Underwriter"))
		{
			txtunderwriter.sendKeys("Tracie Hoch");	
		}
		else if(label.equalsIgnoreCase("Policy Forms"))
		{
			txtpolicyform.sendKeys("Claims Made");	
		}
		else if(label.equalsIgnoreCase("Retroactive Date"))
		{
			txtretrodate.sendKeys(Testbase.getcurrentdate());	
		}
	}
	
	public CoveragePage clickNextonPolicyPage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btnnext);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		return  new CoveragePage();
	}
	
	public LocationDetailPage clickAddLocationonPolicyPage()
	{
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].click();", btnaddlocation);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait,TimeUnit.SECONDS);
		return  new LocationDetailPage();
	}
	
	public PolicyPage() {
		PageFactory.initElements(driver, this);
	}
}
