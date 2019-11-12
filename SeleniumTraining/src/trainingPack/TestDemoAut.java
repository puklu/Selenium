package trainingPack;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestDemoAut {

	public static void main(String[] args) {
		
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		
//		driver.findElement(By.linkText("REGISTER")).click();
		
		driver.findElement(By.cssSelector("input[name='firstName']")).sendKeys("Bat");
		driver.findElement(By.cssSelector("input#username")).sendKeys("bat@abc.com");
		driver.findElement(By.cssSelector("input[name='state']")).sendKeys("Delhi");
		
		new Select(driver.findElement(By.cssSelector("select[name='country']"))).selectByValue("236");
		
		
	}

}
