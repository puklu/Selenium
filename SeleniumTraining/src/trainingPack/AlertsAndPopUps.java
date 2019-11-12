package trainingPack;

import static org.testng.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertsAndPopUps {

	public static void main(String[] args) {

		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			
			driver.get("http://the-internet.herokuapp.com/javascript_alerts");
			
			driver.findElement(By.xpath("//button[contains(text(),'Click for JS Alert')]")).click();
			///// Alert /////
			Alert simpleAlert = driver.switchTo().alert();
			String alertText = simpleAlert.getText();
			System.out.println("The alert said -> " + alertText);
			//accept the alert
			simpleAlert.accept();
            
			//assert msg
			assertEquals(driver.findElement(By.id("result")).getText(), "You successfuly clicked an alert");
			
			
			
			driver.findElement(By.xpath("//button[contains(text(),'Click for JS Confirm')]")).click();
			////////////Confirmation popup //////////////
			Alert simplePopup = driver.switchTo().alert();
			String popupText = simplePopup.getText();
			System.out.println("The popup said -> " + popupText);
			//accept the alert
			simplePopup.accept();
			//simplePopup.dismiss() to click on cancel
            
			//assert msg
			assertEquals(driver.findElement(By.id("result")).getText(), "You clicked: Ok");
			

			
			driver.findElement(By.xpath("//button[contains(text(),'Click for JS Prompt')]")).click();
			////////////Confirmation popup //////////////
			Alert simplePrompt = driver.switchTo().alert();
			String promptText = simplePrompt.getText();
			System.out.println("The prompt said -> " + promptText);
			//accept the alert
			simplePrompt.sendKeys("Heya");
			simplePopup.accept();
			//simplePrompt.dismiss() to click on cancel
            
			//assert msg
			assertEquals(driver.findElement(By.id("result")).getText(), "You entered: Heya");
			
			
			
	}

}
