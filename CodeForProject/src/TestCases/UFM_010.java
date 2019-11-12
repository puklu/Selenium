package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UFM_010 {

	//credentials
    String loginID = "admin";
    String password = "admin@123";
    
  WebDriver driver;
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  @Test
  //Login to the user account
  public void Login() {
 	 	 
 	 //entering username and password
 	 driver.findElement(By.id("input-username")).sendKeys(loginID);
 	 driver.findElement(By.id("input-password")).sendKeys(password);
 	 
 	 //clicking on login button
 	 driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
 	 
 	 //asserting page title
 	 assertEquals(driver.getTitle(), "Dashboard");
 	 System.out.println("Page title asserted:  "+ driver.getTitle());
 	 
  }
  
  

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @BeforeTest
  public void SetUp() {
 	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
 	 driver = new ChromeDriver();
 	 
 	 //opening the site
 	 driver.get("http://uniformm1.upskills.in/admin/");
 	 driver.manage().window().maximize();
 	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	   	     	 
  }
  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @AfterTest
  public void CleanUp() {
 	 driver.close();
 	 driver.quit();
  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
	
}



