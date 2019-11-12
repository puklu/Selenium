package trainingPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XpathPractice2 {

	public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		driver.get("http://newtours.demoaut.com");
		
		//login
		driver.findElement(By.xpath("//input[@name='userName']")).sendKeys("tutorial");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("tutorial");
		driver.findElement(By.xpath("//input[@name='login']")).click();
		
		//flight details
		driver.findElement(By.xpath("//input[@type='radio' and @name='tripType']")).click();
		new Select(driver.findElement(By.xpath("//select[@name='passCount']"))).selectByVisibleText("3");
//		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//select[@name='fromPort']"))).selectByVisibleText("London");
//		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//select[contains(@name,'fromMonth')]"))).selectByVisibleText("November");
//		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//select[contains(@name,'fromDay')]"))).selectByVisibleText("21");
//		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//select[@name='toPort']"))).selectByVisibleText("Paris");
//		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//select[@name='toMonth']"))).selectByVisibleText("November");
//		Thread.sleep(1000);
		new Select(driver.findElement(By.xpath("//select[@name='toDay']"))).selectByVisibleText("29");
		
		//preferences
		driver.findElement(By.xpath("//*[contains(@name,'servClass') and (@value='Coach')]")).click(); 
		new Select(driver.findElement(By.xpath("//select[@name='airline']"))).selectByVisibleText("Unified Airlines");
		
//		Thread.sleep(2000);
		
		//continue
		driver.findElement(By.xpath("//input[@type='image' and @name='findFlights' and contains(@src, 'continue.gif')]")).click();
		
		
		
		
		
		
		
		
	}

}
