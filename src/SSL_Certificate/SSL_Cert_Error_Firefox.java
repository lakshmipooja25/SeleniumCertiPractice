package SSL_Certificate;
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
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SSL_Cert_Error_Firefox {
	
	private WebDriver driver;
	@BeforeClass
	public void setUp() {
		 ProfilesIni prof = new ProfilesIni();
		 FirefoxProfile ffProfile = prof.getProfile("Selenium");   //profile name created
		 ffProfile.setAcceptUntrustedCertificates(true);
		 ffProfile.setAssumeUntrustedCertificateIssuer(false);
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}
	@Test
	public void openApplication() {
		driver.get("https://cacert.org/");
		String pageTitle = driver.getTitle();
		String expectedTitle = "Welcome to CAcert.org";
		Assert.assertEquals(pageTitle, expectedTitle);
	}
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
}