package trainingPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Submit {

	public static void main(String[] args) {

		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.get("http://newtours.demoaut.com");
			
			driver.findElement(By.name("userName")).sendKeys("tutorial");
			driver.findElement(By.name("password")).sendKeys("tutorial");
			
			//submit()
			driver.findElement(By.name("login")).submit();
			
	}

}
