package trainingPack;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FramesAndWindows {

	public static void main(String[] args) {

		   System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			
			/////working with iframes//////////////
			driver.get("http://the-internet.herokuapp.com/iframe");
			WebElement iframeElement = driver.findElement(By.id("mce_0_ifr"));

			driver.switchTo().frame(iframeElement);
			
			driver.findElement(By.id("tinymce")).sendKeys("Hey how you doin there");
			
			driver.switchTo().defaultContent();
			
			
			//////Working with windows///////////
			
			driver.get("http://the-internet.herokuapp.com/windows");
			String handle = driver.getWindowHandle();
			System.out.println("first window handle is: "+handle);
			
			driver.findElement(By.linkText("Click Here")).click();
			
			//store the names of all the open windows now
			Set <String> handles = driver.getWindowHandles();
			System.out.println(handles);
			
			for(String hl: handles) {
				driver.switchTo().window(hl);
			}
			
			
			
			
			
	}

}
