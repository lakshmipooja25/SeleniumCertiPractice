package DataParameterization;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDataParamXML {

	WebDriver driver;
	String url ="http://newtours.demoaut.com";
	
			
	@BeforeSuite
	public void initilize()
	{
	/*System.setProperty("webdriverr.gecko.driver", "E:\\LAKSH\\Selenium\\Selenium Library\\Selenium Drivers\\geckodriver.exe");
	driver =new FirefoxDriver();*/

		System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get(url);
	
	}
	
	
	@Test(priority=2, enabled=true)
	@Parameters({"username","password"})
	public void TestNG_Param1(@Optional("IamOptional")String username, String password) throws InterruptedException
	{ 
		driver.findElement(By.name("userName")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("password")).clear();
		Thread.sleep(3000);
		
		//@Optional("IamOptional")
	}
	
	
}
