import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataParamExcel {

	WebDriver driver;
	String url ="http://newtours.demoaut.com";
	static Workbook book;
	static Sheet sheet;
			
	@BeforeSuite
	public void initilize()
	
	{
	/*System.setProperty("webdriverr.gecko.driver", "E:\\LAKSH\\Selenium\\Selenium Library\\Selenium Drivers\\geckodriver.exe");
	driver =new FirefoxDriver();*/

	System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.get(url);
	}
	
	@Test(priority=2, dataProvider="credential")
	public void TestNG_Param1(String uname, String pswd) throws InterruptedException
	{ 
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pswd);
		Thread.sleep(2000);
		driver.findElement(By.name("userName")).clear();
		driver.findElement(By.name("password")).clear();
		Thread.sleep(2000);
	}
	
	@DataProvider(name="credential")
	public Object[][] getFULLDatafromExcel() throws Exception
	{
		FileInputStream file = null;
		
		file = new FileInputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		book = WorkbookFactory.create(file);
		
		sheet = book.getSheet("Sheet1");
		Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
				DataFormatter formatter = new DataFormatter();
				data[i][k] =formatter.formatCellValue(sheet.getRow(i + 1).getCell(k));
				 
				 System.out.println(data[i][k]);
			}
		}
		return data;	
	}
}
