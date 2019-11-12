package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UFM_009 {

	  WebDriver driver;
	  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


  @Test(priority = 2)
   //the test case of adding an item to the cart 
   public void TestCase_UFM_008() {
     //clicking on premium school uniforms card on home page
     driver.findElement(By.cssSelector("img[alt='banner1']")).click();
     //clicking on a product
     driver.findElement(By.xpath("//div[@id='featured-grid']//child::img[@alt='REGULAR T-SHIRTS (Rust)']")).click();
     //selecting a size
     new Select(driver.findElement(By.id("input-option376"))).selectByValue("964");
     //clicking on add to cart button
     driver.findElement(By.id("button-cart")).click();
     //asserting
     String successText=driver.findElement(By.cssSelector("div.alert-success")).getText().substring(0, 70);
     assertEquals(successText, "Success: You have added REGULAR T-SHIRTS (Rust) to your shopping cart!");
     System.out.println("Asserted that msg: "+ successText+"  :displayed on screen");


}
  
  @Test(priority =3)
   //removing the added item from the cart
   public void TestCase_UFM_009() {
	     //locating the cart button
	     driver.findElement(By.cssSelector("button.dropdown-toggle")).click();
	     //viewing the cart
	     driver.findElement(By.xpath("//a[@href='http://uniformm1.upskills.in/index.php?route=checkout/cart']")).click();
	     //removing the item
	     driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();
	  
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

