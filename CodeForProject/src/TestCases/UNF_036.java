package TestCases;

import static org.testng.Assert.assertEquals;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class UNF_036 {
	
	String loginID = "batsy@cave.com";
    String password = "ghi@123";

		WebDriver driver;
		
		@Test(priority=1)
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
		
		@Test(priority=2)
		public void orderProduct() {
			//going to home page
			driver.findElement(By.linkText("Uniform Store")).click();
			
			 //clicking on premium school uniforms card on home page
			  driver.findElement(By.cssSelector("img[alt='banner1']")).click();
			  //clicking on a product
			  driver.findElement(By.xpath("//div[@id='featured-grid']//child::img[@alt='REGULAR T-SHIRTS (Rust)']")).click();
			  //selecting a size
			  new Select(driver.findElement(By.id("input-option376"))).selectByIndex(3);
			  //clicking on add to cart button
			  driver.findElement(By.id("button-cart")).click();
			  //asserting
			  String successText=driver.findElement(By.cssSelector("div.alert-success")).getText().substring(0, 70);
			  assertEquals(successText, "Success: You have added REGULAR T-SHIRTS (Rust) to your shopping cart!");
			  System.out.println("Asserted that msg: "+ successText+"  :displayed on screen");
			  
			  //locating the cart button
		      WebElement element = driver.findElement(By.cssSelector("button.dropdown-toggle"));
		      JavascriptExecutor jse = ((JavascriptExecutor)driver);				
	            jse.executeScript("arguments[0].click();",element );
			  //viewing the cart
			  WebElement element2 = driver.findElement(By.xpath("//ul[@class='dropdown-menu pull-right cart-menu']/li[2]/div/p/a[1]"));
	            jse.executeScript("arguments[0].click();",element2 );
			 
			  //checking out the product
			  //locating the checkout button
			  driver.findElement(By.linkText("Checkout")).click();
			  
			  //entering details (address, payment etc)
			  driver.findElement(By.xpath("//input[@name='payment_address' and @value='existing']")).click();
			  driver.findElement(By.id("button-payment-address")).click();
			  
			  WebElement element3 = driver.findElement(By.xpath("//input[@name='shipping_address' and @value='existing']"));
	            jse.executeScript("arguments[0].click();",element3 );
			 
	          WebElement element4 = driver.findElement(By.id("button-shipping-address"));
	            jse.executeScript("arguments[0].click();",element4 );
			 

			  driver.findElement(By.id("button-shipping-method")).click();
			  

			  WebElement element5 = driver.findElement(By.xpath("//input[@name='agree']"));
			  if(!element5.isSelected()) {
		            jse.executeScript("arguments[0].click();",element5 );
				 
			  }
			  
			  driver.findElement(By.id("button-payment-method")).click();
			  
			  driver.findElement(By.id("button-confirm")).click();
			  
			  System.out.println("Asserted that: "+ driver.findElement(By.xpath("//*[@id='content']/p")).getAttribute("innerText"));
			  assertEquals(driver.findElement(By.xpath("//*[@id='content']/p")).getAttribute("innerText"), "Your order has been successfully processed!");
			 
			  
			  
			  
		}
		
		@Test(priority=3)
		public void UNF_036_ReturnProduct() {
			driver.findElement(By.xpath("//a[@title='My Account']")).click();
			driver.findElement(By.linkText("Order History")).click();
		    driver.findElement(By.xpath("//tbody/tr[1]/td[7]/a")).click();
		    
		    driver.findElement(By.cssSelector("i.fa-reply")).click();
		    driver.findElement(By.xpath("//input[@name='return_reason_id' and @value='1']")).click();
		    driver.findElement(By.xpath("//input[@name='agree']")).click();
		    driver.findElement(By.xpath("//input[@value='Submit']")).click();
		    
		    assertEquals(driver.getTitle(), "Product Returns");
		    System.out.println("page title asserted after returning the product: "+ "Product Returns");

		    
		}

		
		
		@BeforeTest
		public void setUp() {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.get("http://uniformm1.upskills.in/");
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		
		@AfterTest
		public void tearDown() {
			driver.close();
			driver.quit();
	    }

}
