package Assertion;
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
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Hard_Assertion {
	
	String assertionString="demoforHardAssertion";
	
	  @Test
	  public void test2() {
		 Assert.assertEquals("demoforHardAssertion", assertionString);
		 System.out.println("After Assert equals");
		 Assert.assertTrue(assertionString.equals("demoforHardAssertions"));
		 System.out.println("After Assert true");
	  }
	
	//*************************************************************************************
	/*@Test(priority=1)
	  public void test1() {
		 Assert.assertEquals("demoforHardAssertion", assertionString);
		 System.out.println("After Assert equals");
		 
	  }
	@Test(priority=2)
	public void test2() {
		 
		 Assert.assertTrue(assertionString.equals("demoforHardAssertion"));
		 System.out.println("After Assert true");
	  }*/
}
