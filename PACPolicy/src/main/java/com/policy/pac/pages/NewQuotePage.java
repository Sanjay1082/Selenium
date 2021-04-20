package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class NewQuotePage extends Testbase{
	
	
	@FindBy(xpath=".//div/div[label[text()='Agency:']]/following-sibling::div/div/div")
	@CacheLookup
	WebElement btnagency;
	
	@FindBy(xpath=".//input[@fieldref='data.AgencyID']")
	@CacheLookup
	WebElement txtagency;
	
	//@FindBy(xpath=".//div/div[label[text()='Company']]/following-sibling::div/div/div")
	//WebElement btncompany;
	
	@FindBy(xpath=".//input[@fieldref='PolicyInput.WritingCompany']")
	@CacheLookup
	WebElement txtcompany;
	
	@FindBy(xpath=".//input[@fieldref='PolicyInput.ProductLOB']")
	@CacheLookup
	WebElement txtlob;

	@FindBy(xpath=".//input[@fieldref='PolicyInput.EffectiveDate']")
	@CacheLookup
	WebElement txtpolicyeffectivedate;
	
	@FindBy(xpath=".//div/div[label[text()='State']]/following-sibling::div/div/div")
	@CacheLookup
	WebElement btnstate;
	
	@FindBy(xpath=".//input[@fieldref='data.State']")
	@CacheLookup
	WebElement txtstate;
	
	//@FindBy(xpath=".//div/div[label[text()='Policy Type']]/following-sibling::div/div/div")
	//WebElement btnpolicytype;
	
	@FindBy(xpath=".//input[@fieldref='PolicyInput.PolicyType']")
	@CacheLookup
	WebElement txtpolicytype; 

	//@FindBy(xpath=".//div/div[label[text()='Product Type']]/following-sibling::div/div/div")
	//WebElement btnproducttype;
	
	@FindBy(xpath=".//input[@fieldref='PolicyInput.ProductType']")
	@CacheLookup
	WebElement txtproducttype;
	
	
	@FindBy(xpath=".//span[contains(text(),'Start')]")
	@CacheLookup
	WebElement btnstart;

	
	public void selectagency(String agency) throws Exception
	{	
		btnagency.click();
		driver.findElement(By.xpath(".//li[@unselectable='on' and text()='"+agency+"']")).click();
		//txtagency.clear();
		//txtagency.sendKeys(agency);
		txtagency.sendKeys(Keys.TAB);
		Thread.sleep(2000);
		
	}
	
	public void selectcompany(String company) throws Exception
	{	
		//btncompany.click();
		//driver.findElement(By.xpath(".//div[@fieldref='PolicyInput.WritingCompany']/ul/li[@unselectable='on' and text()='"+company+"']")).click();
		txtcompany.clear();
		txtcompany.sendKeys(company);
		txtcompany.sendKeys(Keys.TAB);
		Thread.sleep(1000);
	}
	
	public void selectdate()
	{
		txtpolicyeffectivedate.sendKeys(Testbase.getcurrentdate());
	}
	
	public void selectproducttype(String producttype) throws Exception
	{	
		//btnproducttype.click();
		txtproducttype.clear();
		txtproducttype.sendKeys(producttype);
		txtproducttype.sendKeys(Keys.TAB);
		//driver.findElement(By.xpath(".//*[@fieldref='PolicyInput.ProductType']")).clear();
		//driver.findElement(By.xpath(".//*[@fieldref='PolicyInput.ProductType']")).sendKeys(producttype);
		//driver.findElement(By.xpath(".//*[@fieldref='PolicyInput.ProductType']")).sendKeys(Keys.TAB);
		Thread.sleep(1000);
	}
	
	public void selectpartytype(String partytype) throws Exception
	{ 
        //btnpolicytype.click();
		//driver.findElement(By.xpath(".//div[@fieldref='PolicyInput.PolicyType']/ul/li[text()='"+partytype+"']")).click();
		txtpolicytype.clear();
		txtpolicytype.sendKeys(partytype);
		txtpolicytype.sendKeys(Keys.TAB);
		Thread.sleep(1000);	
	}
	
	public void selectstate(String state) throws Exception
	{
        btnstate.click();
		driver.findElement(By.xpath(".//div[@fieldref='data.State']/ul/li[@unselectable='on' and text()='"+state+"']")).click();	
		//txtstate.clear();
		//txtstate.sendKeys(state);
		txtstate.sendKeys(Keys.TAB);
		Thread.sleep(1000);
	}
	
	public String getlob()
	{
		return txtlob.getText();
		
	}
	
	public ApplicantPage clickonstart() throws Exception{
		//driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		//Thread.sleep(3000);
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("scroll(0, 250)"); 
		Thread.sleep(3000);
		//Actions builder = new Actions(driver);   
		//builder.moveToElement(btnstart).click().build().perform();
		//String start = ".//div[contains(@class,'g-btn g-standard')]/a/span[text()='    Start     ']";
		//driver.findElement(By.xpath(".//span[contains(text(),'Start')]"))
		jse.executeScript("arguments[0].click();", btnstart);
		//Thread.sleep(3000);
		//btnstart.click();
		//jse.executeScript("scroll(0, 250)"); 
		//Thread.sleep(3000);
		//btnstart.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		return new ApplicantPage();
	}
	
	public NewQuotePage() {
		PageFactory.initElements(driver, this);
    }
}
