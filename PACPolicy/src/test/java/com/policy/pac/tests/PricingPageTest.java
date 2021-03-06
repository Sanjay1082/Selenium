package com.policy.pac.tests;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.policy.pac.base.Testbase;
import com.policy.pac.pages.ApplicantPage;
import com.policy.pac.pages.ClassDeterminationPage;
import com.policy.pac.pages.CoveragePage;
import com.policy.pac.pages.EducatioRiskManagementPage;
import com.policy.pac.pages.HomePage;
import com.policy.pac.pages.LocationDetailPage;
import com.policy.pac.pages.NewQuotePage;
import com.policy.pac.pages.PartySearchPage;
import com.policy.pac.pages.PaymentplanPage;
import com.policy.pac.pages.PolicyPage;
import com.policy.pac.pages.PricingPage;
import com.policy.pac.pages.TransactPage;

public class PricingPageTest extends Testbase{
	
	public ApplicantPage applicantpage;
	public PartySearchPage partysearch;
	public NewQuotePage newquote;
	public HomePage homepage;
	public PolicyPage policypage;
	public LocationDetailPage locationdetailpage;
	public CoveragePage coverage;
	public EducatioRiskManagementPage eduandrsk;
	public ClassDeterminationPage classdetermination;
	public PaymentplanPage paymentdetails;
	public PricingPage pricingpage;
	public TransactPage transactpage;
	
	
	PricingPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setup() {
		Initialization();
		homepage = new HomePage();
	}
	
	@DataProvider
	public Object[][] getdatafromsheet()
	{
		return Testbase.getdata(0);
	}
	
	@Test(dataProvider="getdatafromsheet")
	public void EducatioRiskManagementTest(String agency, String company, String state, String partytype, String producttype, String lastname) throws Exception{
		// New Quote Page
		try {
		newquote = homepage.gotonewquote();
		newquote.selectagency(agency);
		newquote.selectcompany(company);
		newquote.selectdate();
		newquote.selectstate(state);
		newquote.selectpartytype(partytype);
		newquote.selectproducttype(producttype);

		applicantpage =newquote.clickonstart();
		}
		catch(Exception e) {
			System.out.println("Faced issue while populating data on polic page");
		}
		
		//Applicant and Party Search page
		try {
		partysearch = applicantpage.clickonimportparty();
		partysearch.partysearch(lastname);
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
			System.out.println("Faced issue on Coverage page");
		}
		
		//Education and Risk management Page
		try{
			classdetermination =eduandrsk.clicknextOnEduandRskPage();
		}
		catch(Exception e) {
			System.out.println("Faced issue on Edu and Rsk page");
		}
		
		//Class Determination page
		try{
			paymentdetails =classdetermination.clicknextClassDetermination();
		}
		catch(Exception e) {
			System.out.println("Faced issue on Class Determination page");
		}
	
		//Payment plan page
		try{
			paymentdetails.selectPaymentPlan("Fortress Quarterly (Paper Invoices)");
			pricingpage = paymentdetails.clickpreviousonPaymentDetails();
		}
		catch(Exception e) {
			System.out.println("Faced issue on Payment plan page");
		}
		
		//Pricing page
		try{
			transactpage=pricingpage.clickissueonPaymentDetails();
		}
		catch(Exception e) {
			System.out.println("Faced issue on Payment plan page");
		}
		
		System.out.println("Policy Number is: "+driver.findElement(By.xpath(".//*[@fieldref='PolicySummary.PolicyNumber']")).getText());
		
	}


	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}




