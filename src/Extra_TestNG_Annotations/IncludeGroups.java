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


public class IncludeGroups {
	/*@Test(groups = { "car", "ecar" })            
    public void car() {
        System.out.println("Car");
    }
   @Test(groups = { "sedan" })
    public void car1() {
        System.out.println("Car1");
    }
   @Test(groups = { "car" })
    public void car2() {
        System.out.println("Car2");
    }
   @Test(groups = { "hatchback" })
   public void car3() {
       System.out.println("Car3");
   }
   */
   @Test(groups={"action1"})
	  public void f()
	  {System.out.println("f");
	  }
	  @Test(groups={"action2"})
	  public void f1()
	  {System.out.println("f1");
	  }
	  @BeforeSuite
	  public void beforeSuite()
	  {System.out.println("b4 suite");
	  }
	  @AfterSuite
	  public void afterSuite() {
	System.out.println("after suite");
	  }
}