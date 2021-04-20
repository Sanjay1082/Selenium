package com.policy.pac.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.policy.pac.base.Testbase;
import com.policy.pac.pages.HomePage;
import com.policy.pac.pages.NewQuotePage;

public class HomePageTest extends Testbase{
	
	public HomePage homepage;
	public NewQuotePage newquote;
	
	
	HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setup() {
		
		Initialization();
		homepage = new HomePage();
	}
	
	@Test
	public void Navigatetonewquote()
	{
		newquote = homepage.gotonewquote();
	}

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
