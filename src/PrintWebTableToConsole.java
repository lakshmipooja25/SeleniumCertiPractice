import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PrintWebTableToConsole {

	WebDriver driver;
	String url ="https://www.seleniumeasy.com/test/table-data-download-demo.html";
	String url1 ="http://newtours.demoaut.com";
	@Test (priority=1)
	public void initilize()
	{
		System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.get(url);
		//driver.get(url1);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
	}
	
	//@Test (priority=2)	//copy contents of the web table to console with out using individual cell method ONE AFTER OTHER
	public void IterateTableHeaderOneAfterOther()
	{
		WebElement all_ele= driver.findElement(By.xpath("//*[@id='example']//thead"));
		List <WebElement> rows = all_ele.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		for (int i =0; i <rows.size(); i++) {
			List <WebElement> cols = rows.get(i).findElements(By.tagName("th"));
			for(int j=0;j<cols.size();j++)
			{
				String header=cols.get(j).getText();
				System.out.println(header);
			}
		}
		
		WebElement all_ele_body= driver.findElement(By.xpath("//*[@id='example']//tbody"));
		List <WebElement> rowsbody = all_ele_body.findElements(By.tagName("tr"));
		System.out.println(rowsbody.size());
		
		for (int i =0; i <rowsbody.size(); i++) {
			List <WebElement> colsbody = rowsbody.get(i).findElements(By.tagName("td"));
			for(int j=0;j<colsbody.size();j++)
			{
				String body=colsbody.get(j).getText();
				System.out.println(body);
			}
		}
		
	}
	
	@Test(priority=2) // copy contents of the web table to console with out using individual cell method in a SINGLE LINE
	public void IterateSeleniumEasyURLTable() throws Exception
	{
		
		WebElement all_ele= driver.findElement(By.xpath("//*[@id='example']//thead"));
		List <WebElement> rows = all_ele.findElements(By.tagName("tr"));
		System.out.println(rows.size());
		
		for (int i =0; i <rows.size(); i++) {
				String header=rows.get(i).getText();
				System.out.println(header);
			
		}
		WebElement all_ele1= driver.findElement(By.xpath("//*[@id='example']//tbody"));
		List <WebElement> rows1 = all_ele1.findElements(By.tagName("tr"));
		System.out.println(rows1.size());
		
		for (int i =0; i <rows1.size(); i++) {
			String contents=rows1.get(i).getText();
			System.out.println(contents + "|");
		
		}
		System.out.println(" ");
		
	}
	
	@Test(priority=2) // copy paste web table to console  --->  URL1
	public void WebPagetableIterate_copy_paste_table()
	{
		String values=" ";
		String values1=" ";
		WebElement all_ele= driver.findElement(By.xpath("//*[@width='270'][@cellpadding='2']"));
		List <WebElement> rows = all_ele.findElements(By.tagName("tr"));
		for (int i = 0; i < rows.size()-4; i++) {
			List <WebElement> col = rows.get(i).findElements(By.tagName("td"));
			for (int j = 0; j < col.size()-1; j++) {
			 values=col.get(j).getText();
				//System.out.println(values);
				
			}
		}
		//System.out.println(values);
		WebElement all_ele1= driver.findElement(By.xpath("//*[@width='270'][@cellpadding='2']"));
		List <WebElement> rows1 = all_ele1.findElements(By.tagName("tr"));
		for (int i = 0; i < rows1.size()-4; i++) {
			List <WebElement> col1 = rows1.get(i).findElements(By.tagName("td"));
			for (int j = 1; j < col1.size(); j++) {
			 values1=col1.get(j).getText();
				//System.out.println(values1);
				
			}
		}
		//System.out.println(values1);
		System.out.println(values+" | "+values1);
	}
	
	//@Test(priority=2)	// copy ANY KIND of contents of table to console 
		public void Any_Style()
		{
			WebElement all_ele2= driver.findElement(By.xpath("//*[@id='example']//tbody"));
			List <WebElement> rows2 = all_ele2.findElements(By.tagName("tr"));
			for (int i =5; i <rows2.size(); i++) {
				List <WebElement> col2 = rows2.get(i).findElements(By.tagName("td"));
				for (int j = 4; j < col2.size()-1; j++) {
					String values=	col2.get(j).getText();
					try {
					String amount=values.substring(1,8);
					System.out.println(amount);
					}
					catch(Exception e)
					{
						
					}
					
			
				}
			}
			
		}
}
