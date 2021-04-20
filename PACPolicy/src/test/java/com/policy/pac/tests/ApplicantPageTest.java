package com.policy.pac.tests;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.policy.pac.base.Testbase;
import com.policy.pac.pages.ApplicantPage;
import com.policy.pac.pages.PartySearchPage;
import com.policy.pac.utility.TestUtil;
import com.policy.pac.pages.HomePage;
import com.policy.pac.pages.NewQuotePage;

public class ApplicantPageTest extends Testbase{

	public ApplicantPage applicantpage;
	public PartySearchPage partysearch;
	public NewQuotePage newquote;
	public HomePage homepage;
	
	ApplicantPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		homepage = new HomePage();
	}
	
	@Test
	public void applicantTest() throws Exception{
		
		newquote = homepage.gotonewquote();
		newquote.selectagency("Arthur J Gallagher Risk Management Srvs, Inc (IL)");
		newquote.selectcompany("Fortress");
		newquote.selectdate();
		newquote.selectstate("AL");
		newquote.selectpartytype("Individual");
		newquote.selectproducttype("Primary PL");
		//System.out.println(newquote.getlob());

		applicantpage =newquote.clickonstart();
		
		partysearch = applicantpage.clickonimportparty();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		partysearch.partysearch("Test Party 2 - AK");
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		partysearch.selectpartyrecord();
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicitly_Wait, TimeUnit.SECONDS);
		applicantpage.clicknextonapplicant();
	}
	

	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}	

