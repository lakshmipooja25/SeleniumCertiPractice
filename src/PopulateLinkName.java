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

public class PopulateLinkName {
	WebDriver driver;
	String url ="https://www.seleniumeasy.com/test/";
	String url2 ="https://www.seleniumeasy.com/test/basic-checkbox-demo.html";
			
	@BeforeSuite
	public void initilize()
	{

	System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
	driver =new ChromeDriver();
	
	driver.manage().window().maximize();
	
	}
	
	//@Test(priority=2) // get no of links and populate the values from web page to console
	public void LinkName1()
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebElement linkset=driver.findElement(By.xpath("//*[@id='treemenu']"));
		List <WebElement> links=linkset.findElements(By.tagName("a"));
		System.out.println("No of Links present"+links.size());
		for (int i = 1; i<links.size(); i++)
			{
				System.out.println(links.get(i).getText());
			}
	}
	
	//@Test(priority=2)		// get no of sub-links and populate the values from web page to console
	public void SUB_LinkName1() throws InterruptedException
	{
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Thread.sleep(3000);
		driver.findElement(By.id("at-cv-lightbox-close")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"treemenu\"]/li/ul/li[3]/a")).click();
		WebElement linkset=driver.findElement(By.xpath("//*[@class='tree-branch'][3]"));
		List <WebElement> links=linkset.findElements(By.tagName("a"));
		System.out.println("No of Links present"+links.size());
		for (int i = 0; i<links.size(); i++)
			{
				System.out.println(links.get(i).getText());
			}
	}
	
	
		@Test(priority=2)
		public void Checkbox_Iterate_count()
		{
			driver.get(url2);
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			WebElement checkboxset=driver.findElement(By.xpath("//*[@class='col-md-6 text-left']//*[@class='panel panel-default'][2]//*[@class='panel-body']"));
			List <WebElement> checkboxset_value=checkboxset.findElements(By.tagName("input"));
			System.out.println("No of Links present"+checkboxset_value.size());
			/*for (int i = 0; i<checkboxset_value.size(); i++)
				{
					System.out.println(checkboxset_value.get(i).getText());
				}
*/		
			for (int i = 0; i<checkboxset_value.size(); i++)
			{
				checkboxset_value.get(i).click();
			}
		}
}