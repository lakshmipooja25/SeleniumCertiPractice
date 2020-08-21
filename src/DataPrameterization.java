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

public class DataPrameterization {
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
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	
	//@Test(priority=2) // simple iterate the web table and populate values one after other in console
	public void WebPagetableIterate()
	{
		WebElement all_ele= driver.findElement(By.xpath("//*[@width='270'][@cellpadding='2']"));
		List <WebElement> rows = all_ele.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size()-3; i++) {
			List <WebElement> col = rows.get(i).findElements(By.tagName("td"));
			for (int j = 1; j < col.size(); j++) {
			String values=	col.get(j).getText();
				//System.out.println(values);
				String substr=values.substring(1,4);
				System.out.println(substr);
			}
		}
	}
	
	
	
	//@Test(priority=3)           //copy single column from web table to excel sheet. 
	//ie., from zeroth row in excel where header copy is not required
	// if required to copy table, iterate every column in separate loop
	public void putExcel1() throws Exception
	{
		int sheet_row;
		String amount="";
		FileInputStream file = new FileInputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Sheet3");
		
		int row_count=sheet.getLastRowNum();
		System.out.println("Row count"+row_count);
		int col_count = sheet.getRow(1).getLastCellNum();
		
		
		//*[@width='270'][@cellpadding='2']
		WebElement all_ele= driver.findElement(By.xpath("//table[@width='270']//tbody"));
		List <WebElement> rows = all_ele.findElements(By.tagName("tr"));
		for (int i =0; i <rows.size(); i++) {
			List <WebElement> col = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < col.size()-1; j++) {				
				String values=	col.get(j).getText();
				System.out.println(values);
				sheet.getRow(i).createCell(1).setCellValue(values);
				//sheet.getRow(2).createCell(2).setCellValue("major");	
			}
		}
		file.close();
		FileOutputStream out= new FileOutputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		wb.write(out);
		wb.close();		
	}
	

	//@Test(priority=5) // copy cell by cell contents from web table to excel 
	public void putExcel3() throws Exception
	{
		FileInputStream file = new FileInputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Sheet3");
		WebElement all_ele= driver.findElement(By.xpath("//*[@width='270'][@cellpadding='2']"));
		List <WebElement> rows = all_ele.findElements(By.tagName("tr"));
		
		for (int i =0; i <rows.size()-4; i++) {
			List <WebElement> col = rows.get(i).findElements(By.tagName("td"));
			for (int j = 1; j < col.size(); j++) {
				String values=	col.get(j).getText();
				System.out.println(values);
				sheet.getRow(1).createCell(0).setCellValue(values); 
				
		}
		}
		
		for (int i =1; i <rows.size()-3; i++) {
			List <WebElement> col = rows.get(i).findElements(By.tagName("td"));
			for (int j = 1; j < col.size(); j++) {
				String values=	col.get(j).getText();
				String amount=values.substring(1,3);
				sheet.getRow(2).createCell(2).setCellValue(amount); 
			
		}
		}
		
		for (int i =3; i <rows.size()-1; i++) {
			List <WebElement> col = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < col.size()-1; j++) {
				String values=	col.get(j).getText();
				sheet.getRow(4).createCell(1).setCellValue(values); 
		}
		}
		
		for (int i =4; i <rows.size(); i++) {
			List <WebElement> col = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < col.size()-1; j++) {
				String values=	col.get(j).getText();
				
			
		}
		}
		file.close();
		FileOutputStream out= new FileOutputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		wb.write(out);
		wb.close();
		
	}
	
	
	//@Test(priority=5) //get data from excel and feed to web page
	public void getExcel1() throws Exception
	{
		FileInputStream file = new FileInputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Sheet2");
		int no_of_rows = sheet.getLastRowNum()-sheet.getFirstRowNum();
		
		for (int i = 1; i <=(no_of_rows-1); i++) {
			
			DataFormatter formatter = new DataFormatter();
			String username=formatter.formatCellValue(sheet.getRow(i).getCell(0));
			driver.findElement(By.name("userName")).sendKeys(username);
	
			String password=sheet.getRow(i).getCell(1).getStringCellValue();
			driver.findElement(By.name("password")).sendKeys(password);
			
			Thread.sleep(2000);
			driver.findElement(By.name("userName")).clear();
			driver.findElement(By.name("password")).clear();
			Thread.sleep(2000);
		}	
		file.close();
		wb.close();
		driver.quit();
		
	}
}