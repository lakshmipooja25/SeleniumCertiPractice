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


public class Enabled {
	
	/*@Test(priority = 2, dependsOnMethods="test03")
    public void test01() 
    {
        System.out.println("Inside Test01 Method");
    }
    @Test(priority = 0, enabled=true)
    public void test02() 
    {
        System.out.println("Inside Test02 Method");
    }
   // @Test(priority = 1, dependsOnMethods="test02")
    public void test03()
    {
        System.out.println("Inside Test03 Method");
    }*/
	
	//********************************************************************************************
	
	/*@Test(priority = 2)
    public void test01() 
    {
        System.out.println("Inside Test01 Method");
    }
    @Test(priority = 0, enabled=true)
    public void test02() 
    {
        System.out.println("Inside Test02 Method");
    }
    @Test(priority = 1, dependsOnMethods="test02")
    public void test03()
    {
        System.out.println("Inside Test03 Method");
    }
	*/
	//********************************************************************************************
	
	@Test(priority = 2)
    public void test01() 
    {
        System.out.println("Inside Test01 Method");
    }
    @Test(priority = 0, enabled=false)
    public void test02() 
    {
        System.out.println("Inside Test02 Method");
    }
    @Test(priority = 1, dependsOnMethods="test02")
    public void test03()
    {
        System.out.println("Inside Test03 Method");
        
    }
}