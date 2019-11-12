package trainingPack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClick {

	public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		Actions act = new Actions(driver);
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://swisnl.github.io/jQuery-contextMenu/demo.html");
		
		WebElement rclick = driver.findElement(By.xpath("//span[contains(text(), 'right click me')]"));

		//right click
		act.contextClick(rclick).build().perform();
		
		driver.findElement(By.xpath("//li[@class='context-menu-item context-menu-icon context-menu-icon-copy']//span[contains(text(),'Copy')]")).click();
	
	    Alert alert = driver.switchTo().alert();
	    
	    String alertMsg = alert.getText();
	    System.out.println(alertMsg);
	    assertEquals(alertMsg, "clicked: copy");
	    alert.accept();
	}

}
