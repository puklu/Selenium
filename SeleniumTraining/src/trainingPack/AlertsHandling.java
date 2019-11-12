package trainingPack;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsHandling {

	
	static WebDriver driver;
	
	public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://demo.guru99.com/test/delete_customer.php");
		
		driver.findElement(By.name("cusid")).sendKeys("12");
		driver.findElement(By.name("submit")).click();
		Thread.sleep(1000);
        driver.switchTo().alert().accept();
//        Thread.sleep(1000);
//        driver.switchTo().alert().accept(); 
		
	}

}
