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
import org.testng.asserts.SoftAssert;


public class Soft_Assertion {
	
	String assertionString="demoforHardAssertion"; 
	
	 /* @Test
	  public void test2() {
		  //Soft assert Object
		    SoftAssert softAssert=new SoftAssert();
		    softAssert.assertEquals("demoforHardAssertions3", assertionString);
		    System.out.println("After Assert equals");
		    softAssert.assertTrue(assertionString.equals("demoforHardAssert7ions"));
		    System.out.println("After Assert true");
		    softAssert.assertAll();
	  }*/
	
	//**************************************************************************************
	  SoftAssert softAssert=new SoftAssert();
		
		 @Test
		  public void test1() 
		  {
			softAssert.assertEquals("demoforHardAssertion4", assertionString);	 
			//softAssert.assertAll();  
		  }
			
		 @Test
		  public void test2() 
		  {
			 System.out.println("THE start");
			 softAssert.assertEquals("demoforHardAssertion", assertionString);	  
			 softAssert.assertAll(); 
			 System.out.println("THE END");
			  
		  }
}
