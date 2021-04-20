package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class HomePage extends Testbase{

	
	@FindBy(xpath=".//a[@id='id_Home']/span[text()='Home']")
	@CacheLookup
	WebElement home;
	
	@FindBy(xpath=".//li[@class='dropdown']/div[@class='userNameInitial']")
	@CacheLookup
	WebElement user;


	@FindBy(xpath=".//a[@name='name_LogOut' and @id='id_LogOut']")
	@CacheLookup
	WebElement logout;
	
	@FindBy(xpath=".//a[@id='id_New']/span")
	@CacheLookup
	WebElement btnnewquote;
	
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	

	public LoginPage Logout()
	{
		Actions act = new Actions(driver);
		act.click(user).moveToElement(logout).click().build().perform();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		return new LoginPage();
	}
	
	public NewQuotePage gotonewquote() {
		btnnewquote.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		return new NewQuotePage();
	}
  
}
