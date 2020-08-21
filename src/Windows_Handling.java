import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Windows_Handling {
	WebDriver driver;
	String url1 ="http://www.naukri.com/";
	String url2="http://the-internet.herokuapp.com/";
	String url3="https://www.seleniumeasy.com/test/";
			
	@BeforeSuite
	public void initilize()
	{

	System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
	System.setProperty("webdriver.gecko.driver", "");
	driver =new ChromeDriver();
	//driver.get(url1);
	driver.get(url2);
	driver.manage().window().maximize();
	
	}
	
	//@Test(priority=2)
	public void Windows_Handling1() throws Exception
	{
		
		Set <String> allwindows = driver.getWindowHandles();
		
		Iterator<String> i1=allwindows.iterator();
		String s1=i1.next();
		String s2=i1.next();
		System.out.println(s1);
		System.out.println(s2);
		//driver.switchTo().window(s2);
		System.out.println(driver.getTitle());
		//driver.close();
		Thread.sleep(3000);
	//	driver.switchTo().window(s1);
		//System.out.println(driver.getTitle());
		//driver.close();
	}
	
	@Test(priority=2)
	public void Windows_Handling2() throws Exception
	{
		driver.findElement(By.xpath("//*[contains(text(),'Multiple Windows')]")).click();
		driver.findElement(By.linkText("Click Here")).click();

		Set <String> allwindows = driver.getWindowHandles();
		
		Iterator<String> i1=allwindows.iterator();
		String s1=i1.next();
		String s2=i1.next();
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(driver.getTitle());
		driver.switchTo().window(s1);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(s2);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.switchTo().window(s1);
		System.out.println(driver.getTitle());
		Thread.sleep(3000);
		driver.close();
		/*
		driver.close();
		Thread.sleep(3000);
		driver.switchTo().window(s1);
		System.out.println(driver.getTitle());
		driver.navigate().back();
		driver.findElement(By.xpath("//*[contains(text(),'Frames')]")).click();
		//driver.close();
*/		
	
	}
}