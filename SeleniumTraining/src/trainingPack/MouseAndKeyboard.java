package trainingPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import net.bytebuddy.agent.builder.AgentBuilder.InstallationListener.Adapter;

public class MouseAndKeyboard {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
//		
//		
//		
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
//
//		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
//		
//		//login
//		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
//		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
//		driver.findElement(By.id("btnLogin")).click();
//		
//		//create object of Actions class
//		Actions act  = new Actions(driver);
//		
//		//find elements Admin, user management and users
//		WebElement adminMenu = driver.findElement(By.id("menu_admin_viewAdminModule"));
//		WebElement userMgmt = driver.findElement(By.id("menu_admin_UserManagement"));
//		WebElement users = driver.findElement(By.id("menu_admin_viewSystemUsers"));
//		
//		act.moveToElement(adminMenu).build().perform();
//		act.moveToElement(userMgmt).build().perform();
//		act.moveToElement(users).click().build().perform();
//		
//		//all of the above actions in a single statement
//		act.moveToElement(adminMenu).moveToElement(userMgmt).moveToElement(users).click().build().perform();
//	
//		driver.close();
//		driver.quit();
//		
		
		//loggin again to test something else
        driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
        Actions act1 = new Actions(driver);
		//login
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		WebElement perfMenu = driver.findElement(By.id("menu__Performance"));
		WebElement perfMenuConfig = driver.findElement(By.id("menu_performance_Configure"));
		WebElement trackers = driver.findElement(By.xpath("//a[contains(text(), 'Trackers')]"));
		
		act1.moveToElement(perfMenu).moveToElement(perfMenuConfig).moveToElement(trackers).click().build().perform();
		
		
	}

}
