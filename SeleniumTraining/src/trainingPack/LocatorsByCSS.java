package trainingPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LocatorsByCSS {

	public static void main(String[] args) throws InterruptedException {

System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://zero.webappsecurity.com/login.html");
		
		driver.manage().window().maximize();
		
		//CSS Selectors techniques
		
		//By css=#id
		driver.findElement(By.cssSelector("#user_login")).sendKeys("username");
			
		//by css=tag#id
		driver.findElement(By.cssSelector("input#user_password")).sendKeys("password");
		
		//by css=tag[attribute='value']
		driver.findElement(By.cssSelector("input[tabindex='3']")).click();
		
		Thread.sleep(1000);
		//by css=tag.class[attribute='value']
		driver.findElement(By.cssSelector("label.control-label[for='user_remember_me']")).click();
		
		Thread.sleep(1000);
		//by css=tag.class
		driver.findElement(By.cssSelector("input.btn-primary")).click();
		
		driver.findElement(By.linkText("Pay Bills")).click();
		driver.findElement(By.linkText("Purchase Foreign Currency")).click();
		
		Thread.sleep(3000);
		new Select(driver.findElement(By.id("pc_currency"))).selectByVisibleText("Canada (dollar)");
		driver.findElement(By.cssSelector("input#pc_amount")).sendKeys("40");
		driver.findElement(By.cssSelector("input#pc_inDollars_true")).click();
		driver.findElement(By.cssSelector("input#pc_calculate_costs")).click();
		
		Thread.sleep(1000);
		
		
		driver.findElement(By.cssSelector("input[value='Purchase']")).click();
	}

}
