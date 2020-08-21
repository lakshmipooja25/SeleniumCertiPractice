import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
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

public class PopulateDropdown {
	WebDriver driver;
	String url ="https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html";
	String url2="http://the-internet.herokuapp.com/dropdown";
			
	@BeforeSuite
	public void initilize()
	{
	/*System.setProperty("webdriverr.gecko.driver", "E:\\LAKSH\\Selenium\\Selenium Library\\Selenium Drivers\\geckodriver.exe");
	driver =new FirefoxDriver();*/

	System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.get(url);
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//@Test(priority=2)
	public void dropDown1_url()
	{
		WebElement drop=driver.findElement(By.id("select-demo"));
		List <WebElement> drop_list=drop.findElements(By.tagName("option"));
		for(int i=1;i<drop_list.size();i++)
		{
			String values=drop_list.get(i).getText();
			System.out.println(values);
		}
		
	}
	
	
}