package trainingPack;

import java.awt.RenderingHints.Key;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class KeyboardActions {

	public static void main(String[] args) {

		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			Actions act = new Actions(driver);
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.get("https://google.com");
			
			WebElement searchBox = driver.findElement(By.name("q"));
			
			//keystrokes
			act.keyDown(searchBox, Keys.SHIFT).sendKeys("java geeks").keyUp(searchBox, Keys.SHIFT).doubleClick().build().perform();			
			
			
			//pressing enter
			act.sendKeys(searchBox, Keys.ENTER).build().perform();
			System.out.println("enter pressed");
			
			
			
		
	}

}
