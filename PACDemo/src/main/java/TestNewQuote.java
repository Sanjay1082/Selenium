import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestNewQuote extends Testbase{
	
	public static String getcurrentdate()
	{

	    Date current = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    return formatter.format(current);  
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		TestNewQuote base = new TestNewQuote();
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\M1056369\\Desktop\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		
		String url = "http://"+pro.getProperty("OmsnicDomainUser")+":"+pro.getProperty("OmsnicDomainPass")+"@"+"172.16.110.50:8080/ExpressQA/default.aspx";
		
		//String url = TestNewQuote.pro.getProperty("Password");
		System.out.println(url);
		
        driver.get(url);

        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.xpath(".//a[@id='id_New']/span")).click();
		
		
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath(".//input[@fieldref='data.AgencyID']")).sendKeys("Arthur J Gallagher Risk Management Srvs, Inc (IL)");
		driver.findElement(By.xpath(".//input[@fieldref='PolicyInput.EffectiveDate']")).sendKeys(TestNewQuote.getcurrentdate());
		System.out.println(getcurrentdate());
		driver.findElement(By.xpath(".//input[@fieldref='PolicyInput.WritingCompany']")).sendKeys("Fortress");
		driver.findElement(By.xpath(".//input[@fieldref='PolicyInput.ProductType']")).sendKeys("Primary PL");
		driver.findElement(By.xpath(".//input[@fieldref='PolicyInput.PolicyType']")).sendKeys("Individual");
		driver.findElement(By.xpath(".//input[@fieldref='data.State']")).sendKeys("AL");
		driver.findElement(By.xpath(".//div[@class='g-btn g-standard  ']/a[span[@class='g-btn-text']]")).click();
		
		Thread.sleep(5000);
        
}
}