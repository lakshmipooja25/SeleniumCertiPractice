package DataParameterization;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGDataParamThriceXML {

	WebDriver driver;
	
	/*@Test
	@Parameters({"browser","url", "username", "password"})
	public void Test1(String lbrowser, String lurl, String username, String password) throws Exception
	{
		if (lbrowser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.get(lurl);
			driver.findElement(By.name("userName")).sendKeys(username);
			driver.findElement(By.name("password")).sendKeys(password);
			Thread.sleep(3000);
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("password")).clear();
			Thread.sleep(3000);
		}*/
	
	//*******************************************************************************************************************
	
	@BeforeMethod
	@Parameters({"browser","url"})
	public void Test1(String lbrowser, String lurl) throws Exception
	{
		/*if (lbrowser.equalsIgnoreCase("chrome"))
		{*/
			System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.get(lurl);
		//}	
		
	}
	
	@Test
	@Parameters({"username","password"})
	public void filldetails(String uname, String pswd) throws Exception
	{
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pswd);
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("password")).clear();
		Thread.sleep(3000);
	}
	
}
