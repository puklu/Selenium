package testNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.*;

public class OpenAndCloseBrowser {

	
		
		WebDriver driver;
		
		
		
		
		
		//test case
		@Test
		public void test_login() {
			
			driver.findElement(By.id("user_login")).sendKeys("admin");
			driver.findElement(By.id("user_password")).sendKeys("admin");
			driver.findElement(By.name("submit")).click();
			
			
			
		}
		
		@Test
		public void test2(){
			System.out.println("test 2");
		}
		
		@Test
		public void test3() {
			System.out.println("test 3");
		}
		
		
		//setup
				@BeforeTest
				public void setUp() {

		        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
				
				driver = new ChromeDriver();
				
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
				driver.get("http://zero.webappsecurity.com/login.html");
				
				driver.manage().window().maximize();
				
				}
		
		//cleanup
		@AfterTest
		public void cleanUp() {
			driver.close();
			driver.quit();
		}

	

}
