package trainingPack;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CollectingLinks {

	public static void main(String[] args) {

		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

			driver.get("http://newtours.demoaut.com");
			
			List<WebElement> links = driver.findElements(By.tagName("a"));
			
			String[] linkTexts = new String[links.size()];
			
			int i=0;
			for( WebElement li:links) {
				linkTexts[i] = li.getText();
				System.out.println(li.getText());
				i++;
			}
			
			for(String lt : linkTexts) {
				driver.findElement(By.linkText(lt)).click();
				
			}
			
	}

}
