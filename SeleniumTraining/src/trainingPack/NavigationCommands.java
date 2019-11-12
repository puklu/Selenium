package trainingPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationCommands {

	public static void main(String[] args) {

		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("http://zero.webappsecurity.com");
			
			driver.findElement(By.id("signin_button")).click();
			
			//navigate back
			driver.navigate().back();
			
			//navigate forward
			driver.navigate().forward();
			
			//navigate- refresh
			driver.navigate().refresh();
			
			//navigate to some URL
			driver.navigate().to("http://newtours.demoaut.com");
			
			//navigate to some URL
			driver.navigate().to("http://zero.webappsecurity.com");
			
			
	}

}
