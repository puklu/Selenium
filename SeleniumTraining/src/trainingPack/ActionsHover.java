package trainingPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsHover {
	
	static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.get("http://demoqa.com/menu/");
		
		Actions actions = new Actions(driver);
		
		WebElement musicElement = driver.findElement(By.xpath("//*[@id=\"ui-id-9\"]"));		
		actions.moveToElement(musicElement).perform();
		System.out.println("moved to music");
		
		Thread.sleep(1000);
		
		WebElement rockElement = driver.findElement(By.xpath("//*[@id=\"ui-id-10\"]"));		
		actions.moveToElement(rockElement).perform();
		System.out.println("moved to rock");
		

	}

}
