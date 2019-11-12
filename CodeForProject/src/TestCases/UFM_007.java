package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UFM_007 {
	
	//credentials
    String loginID = "vivpunia@in.ibm.com";
    String password = "xyz123";
    String newPassword = "abc123";
    
  WebDriver driver;
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  @Test(priority = 1)
  //Login to the user account
  public void Login() {
 	 //clicking on My Account button
 	 driver.findElement(By.cssSelector("i.fa-user")).click();
 	 
 	 //clicking on login on the dropdown
 	 driver.findElement(By.xpath("//a[contains(text(), 'Login')]")).click();
 	 
 	 //entering username and password
 	 driver.findElement(By.id("input-email")).sendKeys(loginID);
 	 driver.findElement(By.id("input-password")).sendKeys(password);
 	 
 	 //clicking on login button
 	 driver.findElement(By.xpath("//input[@value='Login']")).click();
 	 
  }
  
  @Test(priority = 2)
  //The test case of entering mismatching password while changing the password
  public void TestCase_UFM_007() {
 	 //clicking on change password
     driver.findElement(By.linkText("Change your password")).click();
     //Entering the new password that the user want
 	 driver.findElement(By.id("input-password")).sendKeys(newPassword);
 	 //confirming the password again
 	 driver.findElement(By.id("input-confirm")).sendKeys(newPassword+"balalala");
 	 //clicking on continue
 	 driver.findElement(By.xpath("//input[@value='Continue']")).click();
 	  
 	 //asserting that the text Password confirmation does not match password! has been displayed to the user
 	 assertEquals(driver.findElement(By.cssSelector("div.text-danger")).getText(), "Password confirmation does not match password!");
 	 System.out.println("Asserted that the text: "+ driver.findElement(By.cssSelector("div.text-danger")).getText() +" :has been displayed to the user");
 
  
  
  }

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @BeforeTest
  public void SetUp() {
 	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
 	 driver = new ChromeDriver();
 	 
 	 //opening the site
 	 driver.get("http://uniformm1.upskills.in/");
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

