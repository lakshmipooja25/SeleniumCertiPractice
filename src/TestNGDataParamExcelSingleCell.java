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

public class TestNGDataParamExcelSingleCell {

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
		public Object[][] getCHOSENDataFromExcel() throws Exception
		{
		FileInputStream file = new FileInputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Sheet1");
		int no_of_rows = sheet.getLastRowNum()-sheet.getFirstRowNum();
		System.out.println(no_of_rows);
		
		String username1 = null;
		for (int i = 1; i <=(no_of_rows-3); i++) {
			DataFormatter formatter = new DataFormatter();
			username1=formatter.formatCellValue(sheet.getRow(i).getCell(0));
		}
		String password1=null;
		for (int i = 1; i <=(no_of_rows-3); i++) {
			DataFormatter formatter = new DataFormatter();
			password1=formatter.formatCellValue(sheet.getRow(i).getCell(1));
		}
		
		String username2 = null;
		for (int i = 2; i <=(no_of_rows-2); i++) {
			DataFormatter formatter = new DataFormatter();
			username2=formatter.formatCellValue(sheet.getRow(i).getCell(0));
		}
		String password2=null;
		for (int i = 2; i <=(no_of_rows-2); i++) {
			DataFormatter formatter = new DataFormatter();
			password2=formatter.formatCellValue(sheet.getRow(i).getCell(1));
		}
		
		String username3 = null;
		for (int i = 3; i <=(no_of_rows-1); i++) {
			DataFormatter formatter = new DataFormatter();
			username3=formatter.formatCellValue(sheet.getRow(i).getCell(0));
		}
		String password3=null;
		for (int i = 3; i <=(no_of_rows-1); i++) {
			DataFormatter formatter = new DataFormatter();
			password3=formatter.formatCellValue(sheet.getRow(i).getCell(1));
		}
		
		String username4 = null;
		for (int i = 4; i <=(no_of_rows); i++) {
			DataFormatter formatter = new DataFormatter();
			username4=formatter.formatCellValue(sheet.getRow(i).getCell(0));
		}
		String password4=null;
		for (int i = 3; i <=(no_of_rows); i++) {
			DataFormatter formatter = new DataFormatter();
			password4=formatter.formatCellValue(sheet.getRow(i).getCell(1));
		}
		Object[][] data = new Object [4][2];
		data[0][0]=username1;
		data[0][1]=password1;
		
		data[1][0]=username2;
		data[1][1]=password2;
		
		data[2][0]=username3;
		data[2][1]=password3;
		
		data[3][0]=username4;
		data[3][1]=password4;
		return data;
		}
}
