package Extra_TestNG_Annotations;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class ExcludeGroups {
	
	/*@Test(groups = { "ecar", "ebike" })
	public void bike() {
	        System.out.println("car & bike");
	}
	@Test(groups = { "ebike" })
	public void bike1() {
		System.out.println("bike only ");
	}
	@Test(groups = { "ecar" })
	public void bike2() {
		System.out.println("car only");
	}
	
	@Test(groups = { "hatchback" })
	   public void car3() {
	       System.out.println("Car3");
	   }*/
	
	 
	
}