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

public class TestNG_Param_DataProvider {

	WebDriver driver;
	
	@BeforeSuite
	@Parameters({"Browsername","url"})
	public void initilize(@Optional("IE")String Browsername1,String url1)
	{
		if (Browsername1.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.get(url1);
			
			}
		else if(Browsername1.equalsIgnoreCase("firefox"))
		{
			System.out.println("Firefox is opened");
		}
		else
		{
			System.out.println("OPTIONAL VALUE : " +Browsername1);
		}
		
	}
	//@Test(priority=2, dataProvider="credential")
	
	public void TestNG_Param1(  String uname, String pswd) throws InterruptedException
	{ 
		
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pswd);
		Thread.sleep(3000);
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("password")).clear();
		Thread.sleep(3000);
		
		//@Optional("IamOptional")
	}
	
	@DataProvider(name="credential")
	public Object[][] getData()
	{
		Object[][] data = new Object [3][2];
		
		data[0][0]="laksh";
		data[0][1]="laksh@123";
		
		data[1][0]="prath";
		data[1][1]="prath@123";
		
		data[2][0]="suja";
		data[2][1]="suja@123";
		
		return data;
	}
	
	
}
