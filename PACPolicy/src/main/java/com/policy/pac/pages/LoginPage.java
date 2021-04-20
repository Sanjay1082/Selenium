package com.policy.pac.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.policy.pac.base.Testbase;
import com.policy.pac.utility.TestUtil;

public class LoginPage extends Testbase{
	
	
	@FindBy(id="username-inputEl")
	@CacheLookup
	WebElement txtusername;
	
	@FindBy(id="password-inputEl")
	@CacheLookup
	WebElement txtpassword;


	@FindBy(xpath=".//span[@class='g-btn-text' and text()='Login']")
	@CacheLookup
	WebElement btnlogin;
	
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
        }
	
	public HomePage login() {
		txtusername.sendKeys(pro.getProperty("UserName"));
		txtpassword.sendKeys(pro.getProperty("Password"));
		btnlogin.click();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		return new HomePage();
	}
}
