package com.policy.pac.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.policy.pac.base.Testbase;
import com.policy.pac.pages.ApplicantPage;
import com.policy.pac.pages.CoveragePage;
import com.policy.pac.pages.EducatioRiskManagementPage;
import com.policy.pac.pages.HomePage;
import com.policy.pac.pages.LocationDetailPage;
import com.policy.pac.pages.NewQuotePage;
import com.policy.pac.pages.PartySearchPage;
import com.policy.pac.pages.PolicyPage;

public class CoveragePageTest extends Testbase{
	
	public ApplicantPage applicantpage;
	public PartySearchPage partysearch;
	public NewQuotePage newquote;
	public HomePage homepage;
	public PolicyPage policypage;
	public LocationDetailPage locationdetailpage;
	public CoveragePage coverage;
	public EducatioRiskManagementPage eduandrsk;
	
	
	CoveragePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		homepage = new HomePage();
	}
	
	@Test
	public void CoveragepageTest() throws Exception{
		// New Quote Page
		try {
		newquote = homepage.gotonewquote();
		newquote.selectagency("Arthur J Gallagher Risk Management Srvs, Inc (IL)");
		newquote.selectcompany("Fortress");
		newquote.selectdate();
		newquote.selectstate("AL");
		newquote.selectpartytype("Individual");
		newquote.selectproducttype("Primary PL");

		applicantpage =newquote.clickonstart();
		}
		catch(Exception e) {
			System.out.println("Faced issue while populating data on polic page");
		}
		
		//Applicant and Party Search page
		try {
		partysearch = applicantpage.clickonimportparty();
		partysearch.partysearch("Test Party 2 - AK");
		partysearch.selectpartyrecord();
		
		}
		catch(Exception e) {
			System.out.println("Faced issue while searcing party record");
		}
		
		//Policy Page
		try {
		policypage = applicantpage.clicknextonapplicant();
		
		policypage.populateDataonPolicyPage("Retroactive Date", "Current Date");
		locationdetailpage = policypage.clickAddLocationonPolicyPage();
		locationdetailpage.populateDataonLocationPage("Zip COde", "12345");
		locationdetailpage.clickokonlocationdeatils();
		coverage =policypage.clickNextonPolicyPage();
		}
		catch(Exception e) {
			System.out.println("Faced issue on policy page");
		}
		
		//Coverage page
		try{
		eduandrsk =coverage.clicknextOnCoveragePage();
		}
		catch(Exception e) {
			System.out.println("Faced issue on policy page");
		}
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}




