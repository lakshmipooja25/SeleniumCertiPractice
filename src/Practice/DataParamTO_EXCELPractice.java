package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import net.bytebuddy.dynamic.scaffold.MethodRegistry.Handler.ForAbstractMethod;

public class DataParamTO_EXCELPractice {

	WebDriver driver;
	String url ="https://www.seleniumeasy.com/test/table-data-download-demo.html";
			
	@Test (priority=1)
	public void initilize()
	{
	System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
	driver =new ChromeDriver();
	driver.get(url);
	driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	}
	
	
	//@Test(priority=2) // Iterate header records from web table to sheet
	public void IterateSeleniumEasyURLTable1() throws Exception
	{
		FileInputStream file = new FileInputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Sheet4");
		WebElement all_ele= driver.findElement(By.xpath("//*[@id='example']//thead"));
		List <WebElement> rows = all_ele.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		for (int i =0; i <rows.size(); i++) {
			List <WebElement> header_col=rows.get(i).findElements(By.tagName("th"));
			System.out.println(header_col.size());
			for (int j = 0; j < header_col.size()-2; j++) {
				String header=	header_col.get(j).getText();
			System.out.println(header);
			sheet.getRow(0).createCell(j).setCellValue(header); 
			}
		}
		file.close();
		FileOutputStream out= new FileOutputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		wb.write(out);
		wb.close();
	}
	
	
	
	//@Test(priority=4) // Iterate body records of the table from web table to sheet
	public void putExcel2() throws Exception
	{
		FileInputStream file = new FileInputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Sheet4");
		
		//THE COMMENTED WILL NOT WORK BUT STILL FOR REFERENCE ONLY
		/*//*[@id='example']//thead//tr//th[1]
		String before_String_header="//*[@id='example']//thead//tr//th[";
		String after_string_header="]";
		for(int i=1;i<=4;i++)
		{
		String actual_header=before_String_header+i+after_string_header;
		String header_records=driver.findElement(By.xpath(actual_header)).getText();
		sheet.getRow(0).createCell(i).setCellValue(header_records);
		}*/
		
		String before_nameXpath="//*[@id='example']//tbody//tr[";
		String after_nameXpath="]//td[1]";
	
		for (int i = 1; i <=10; i++) {
			String actual_nameXpath=before_nameXpath+i+after_nameXpath;
			String names=driver.findElement(By.xpath(actual_nameXpath)).getText();
			System.out.println(names);	
			sheet.getRow(i).createCell(0).setCellValue(names);
		}
		
		
		String before_posXpath="//*[@id='example']//tbody//tr[";
		String after_posXpath="]//td[2]";
		
		for (int i = 1; i <=10; i++) {
			String actual_posXpath=before_posXpath+i+after_posXpath;
			String position=driver.findElement(By.xpath(actual_posXpath)).getText();
			System.out.println(position);
			sheet.getRow(i).createCell(1).setCellValue(position);
		}
		
		file.close();
		FileOutputStream out= new FileOutputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		wb.write(out);
		wb.close();
	}
	
	//@Test(priority=2) 	// copy contents of webtable in single line and paste to excel ---> HEADER/BODY RECORDS
	public void testsample() throws Exception
	{
		String before_nameXpath="//*[@id='example']//tbody//tr[";
		String after_nameXpath="]";
		
		FileInputStream file = new FileInputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		XSSFWorkbook wb= new XSSFWorkbook(file);
		XSSFSheet sheet=wb.getSheet("Sheet4");
		
		for (int i = 1; i <=10; i++) {
			String actual_nameXpath=before_nameXpath+i+after_nameXpath;
			String names=driver.findElement(By.xpath(actual_nameXpath)).getText();
			System.out.println(names);	
			sheet.getRow(i).createCell(0).setCellValue(names);
		}
		file.close();
		FileOutputStream out= new FileOutputStream("E:\\LAKSH\\Selenium\\Selenium Practice\\TestParameterization.xlsx");
		wb.write(out);
		wb.close();
	}
}

