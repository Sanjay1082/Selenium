package com.policy.pac.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.policy.pac.base.Testbase;
import com.policy.pac.pages.ApplicantPage;
import com.policy.pac.pages.HomePage;
import com.policy.pac.pages.NewQuotePage;

public class NewQuotePageTest extends Testbase{
	
	public NewQuotePage newquote;
	public ApplicantPage applicantpage;
	public HomePage homepage;
	
	
	NewQuotePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
	Initialization();	
	newquote = new	NewQuotePage();
	homepage=new HomePage();
	}
	
	@Test
	public void populatedataonnewquotepageTest() throws Exception
	{
		newquote = homepage.gotonewquote();
		newquote.selectagency("Arthur J Gallagher Risk Management Srvs, Inc (IL)");
		newquote.selectcompany("Fortress");
		newquote.selectdate();
		newquote.selectstate("AL");
		newquote.selectpartytype("Individual");
		newquote.selectproducttype("Primary PL");
		//System.out.println(newquote.getlob());

		applicantpage =newquote.clickonstart();

	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}	

}
