package trainingPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMethods {

	public static void main(String[] args) {
		
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			
			//////////////// Implicit wait  /////////////////////
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			
			driver.get("http://newtours.demoaut.com");
			
			//login
			driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("tutorial");
			driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tutorial");
			driver.findElement(By.xpath("//input[@name='login']")).click();
			
			
			////////////// Explicit Wait ////////////
			WebDriverWait ewait = new WebDriverWait(driver, 10);
			WebElement button = ewait.until(ExpectedConditions.elementToBeClickable(By.name("findFlights")));
			button.click();
	}

}
