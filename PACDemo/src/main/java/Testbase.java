

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

public class Testbase {

	public static WebDriver driver;
	public static Properties pro;
	
	public Testbase()
	{
		try {
			pro =new Properties();
			FileInputStream file = new FileInputStream("C:\\Users\\M1056369\\eclipse-workspace\\PACDemo\\src\\main\\java\\Config.property");
			pro.load(file);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/*
	public static void Initialization(String value) {
		
		String browser = pro.getProperty("browser");
		
		if(browser.equals(value))
		{
			
		}
		else if(browser.equals(value))
		{
			
		}
		else if(browser.equals(value))
		{
			
		}
		else
		{
			
		}
	}
	
	public static String getcurrentdate()
	{

	    Date current = new Date();
	    SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");  
	    return formatter.format(current);  
	}
	*/
}
