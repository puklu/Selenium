package trainingPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Sliders {

	public static void main(String[] args) {

		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			Actions act = new Actions(driver);
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.get("https://jqueryui.com/slider");
			
			driver.switchTo().frame(0);
			
			WebElement slider = driver.findElement(By.xpath("//*[@id='slider']/span"));
			
			//move the slider
			act.moveToElement(slider).dragAndDropBy(slider, 300, 0).build().perform();
			
			//OR
			//using moveByOffset
			act.clickAndHold().moveByOffset(20, 0).release().build().perform();
			
			
			
			///////////////////////////////////////////////////////
			
			driver.navigate().to("https://jqueryui.com/resizable");
			
			driver.switchTo().frame(0);
			
			Actions act2 = new Actions(driver);
			
			WebElement resizer = driver.findElement(By.xpath("//div[@id='resizable']/div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']"));
			
			//resize the box
			act2.moveToElement(resizer).dragAndDropBy(resizer, 30, 30).build().perform();
			
	}

}
