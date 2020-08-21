package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Xpath_Axes_Practice {

	WebDriver driver;
	String url ="https://www.seleniumeasy.com/test/table-data-download-demo.html";
			
	@BeforeSuite 
	public void initilize()
	{
	System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	//@Test()
	public void iterate_xpath_contents()
	{
		List <WebElement> values =driver.findElements(By.xpath("//*[@id='example']//thead//tr//th[1]//following::th"));
		for(int i=0;i<values.size();i++)
		{
			String text_contents =values.get(i).getText();
			System.out.println(text_contents);
		}
	}
	
	@Test()
	public void iterate_xpath_single_contents()
	{
		String single_value=driver.findElement(By.xpath("//*[@id='example']//thead//tr//th[1]//following::th[last()]")).getText();
		System.out.println(single_value);
	}
	
}

