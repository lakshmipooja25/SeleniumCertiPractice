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


public class dependsOnMethods {
	
	/*@Test(priority=1)
    public void login() 
    {
        System.out.println("Code to login into the AUT");
    }
   
	@Test(dependsOnMethods = { "login" })
    public void dashboard()
    {
        System.out.println("Dashboard Page");
    }
   
    @Test(dependsOnMethods = { "dashboard" })
    public void customerData() 
    {
        System.out.println("Customer Data Page");
    }*/
//**************************************************************************************************************
   /* @Test
    public void independant1() 
    {
        System.out.println("Independant Page 1 ");
    }
    
    //@Test
    public void independant2() 
    {
        System.out.println("Independant Page 2");
    }
    
    @Test(dependsOnMethods = { "independant1", "independant2"})
    public void dependant_on_1_and_2() 
    {
        System.out.println("I am dependant on 1 and 2");
    }*/
    
    //************************************************************************************************************
    /*@Test(enabled=false)
    public void login() {
    	System.out.println("Login");
    }
    
    @Test(dependsOnMethods="login")
    public void dashboard() {
    	System.out.println("Dashboard");
    }

    @Test(dependsOnMethods={"login","dashboard"})
    public void logout() {
    	System.out.println("Logout");
    }*/
	//***************************************************************************************************************
	
	/*@Test
    public void login() 
    {
        System.out.println("Code to login into the AUT");
    }
   
	@Test
    public void dashboard()
    {
        System.out.println("Dashboard Page");
    }
   
    @Test
    public void customerData() 
    {
        System.out.println("Customer Data Page");
    }*/
    
  //***************************************************************************************************************
	/*
	@Test
    public void abhi() 
    {
        System.out.println("Code to login into the AUT");
    }
   
	@Test
    public void test1()
    {
        System.out.println("Dashboard Page");
    }
   
    @Test
    public void test2() 
    {
        System.out.println("Customer Data Page");
    }*/
	
	//***************************************************************************************************************
	
}