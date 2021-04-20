package com.policy.pac.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.policy.pac.utility.EventHandler;

public class Testbase {

	public static WebDriver driver;
	public static Properties pro;
	public static WebDriverWait wait;
	public static EventFiringWebDriver e_driver;
	public static EventHandler eventListener;
	
	public Testbase()
	{
		try {
			pro = new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\M1056369\\eclipse-workspace\\PACPolicy\\src\\main\\java\\com\\policy"
					+ "\\pac\\config\\Config.property");
			pro.load(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void Initialization() {
		
		String browser = pro.getProperty("browser");
		
		if(browser.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\M1056369\\Desktop\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equals("IE"))
		{
			
		}
		else if(browser.equals("FireFox"))
		{
			
		}
		else
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\M1056369\\Desktop\\Selenium\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		e_driver = new EventFiringWebDriver(driver);
		eventListener = new EventHandler();
		e_driver.register(eventListener);
		driver = e_driver;
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		String url = "http://"+pro.getProperty("OmsnicDomainUser")+":"+pro.getProperty("OmsnicDomainPass")+"@"+"172.16.110.50:8080/ExpressQA/default.aspx";
        driver.get(url);
	}
	
	public static String getcurrentdate()
	{
	    Date current = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    return formatter.format(current);  
	}
	
	/*
	@SuppressWarnings("deprecation")
	public static Boolean explicitlywait(String xpath, String value)
	{
		wait=new WebDriverWait(driver, 20);
		
		Boolean element=wait.until(ExpectedConditions.textToBe(By.xpath(xpath), value));
		return element;
	}
	*/
	
	
	public static void takeScreenshotAtEndOfTest()
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("C:\\Users\\M1056369\\eclipse-workspace\\PACPolicy\\Screenshot\\Screenshot"+System.currentTimeMillis()+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static Object[][] getdata(int index)
	{
	String excelFilePath = "C:\\Users\\M1056369\\eclipse-workspace\\PACPolicy\\src\\main\\java\\com\\policy\\pac\\testdata\\CreatePolicy.xlsx";
    FileInputStream inputStream = null;
	try {
		inputStream = new FileInputStream(new File(excelFilePath));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
    Workbook workbook = null;
	try {
		workbook = new XSSFWorkbook(inputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Sheet sheet = workbook.getSheetAt(index);
    Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i=0;i<sheet.getLastRowNum();i++) 
	{
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			System.out.println("Data is : "+data[i][k]);
		}
		System.out.println();
	}
	return data;
}
}

