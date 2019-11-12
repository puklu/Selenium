package trainingPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class firstSample {
	
	static WebDriver driver;
	
	
	public static void main(String[] args) {
	
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
//		System.setProperty("webdriver.gecko.driver","C:\\Users\\VivekPunia\\Documents\\Selenium");
			
    driver = new ChromeDriver();
    
    driver.get("http://newtours.demoaut.com");
			
//		driver.quit();	
}
	
}
