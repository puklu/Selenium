package trainingPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ZeroApp {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://zero.webappsecurity.com/index.html");
	
		driver.manage().window().maximize();
		
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.name("user_login")).sendKeys("username");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.partialLinkText("Forgot")).click();
		
		Thread.sleep(5000);
	    driver.close();
	    driver.quit();
	    
	}

}
