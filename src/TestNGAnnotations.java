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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class TestNGAnnotations {
	
	//To be noted: BeforeSuite -> BeforeTest -> BeforeClass -> BeforeMethod -> Test Method  -> AfterMethod -> AfterClass -> AfterTest -> AfterSuite
	// To be noted:  Sequence of xml tags  <suite> <test> <classes> <class> <methods>
	@Test
    public void test1() {
        System.out.println("Inside Test 1  Method");
    }
	
	@Test
    public void test2() {
        System.out.println("Inside Test 2  Method");
    }
	
	@BeforeClass
    public void testclass() {
        System.out.println("execute test class");
    }
    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Inside Before Method");
    }
    @AfterMethod
    public void afterMethod() {
        System.out.println("Inside After Method");
    }
    
    @AfterClass
    public void afterClass() {
        System.out.println("Inside AfterClass Method");
    }
    @BeforeTest
    public void beforeTest() {
        System.out.println("Inside BeforeTest Method");
    }
    @AfterTest
    public void afterTest() {
        System.out.println("Inside AfterTest Method");
    }
    @BeforeSuite
    public void beforeSuite() {
    System.out.println("Inside BeforeSuite Method");
    }
    @AfterSuite
    public void afterSuite() {
        System.out.println("Inside AfterSuite Method");
    }

}