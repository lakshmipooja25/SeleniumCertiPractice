import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNGDataParamOwn {

	WebDriver driver;
	String url ="http://newtours.demoaut.com";
			
	@BeforeSuite
	public void initilize()
	{
	/*System.setProperty("webdriverr.gecko.driver", "E:\\LAKSH\\Selenium\\Selenium Library\\Selenium Drivers\\geckodriver.exe");
	driver =new FirefoxDriver();*/

	System.setProperty("webdriver.chrome.driver", "E:\\LAKSH\\Selenium\\chromedriver.exe");
	driver =new ChromeDriver();
	
	}
	
	@Test(priority=2, dataProvider="credential")
	public void TestNG_Param1(String uname, String pswd)
	{ 
		driver.get(url);
		driver.findElement(By.name("userName")).sendKeys(uname);
		driver.findElement(By.name("password")).sendKeys(pswd);
			
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
