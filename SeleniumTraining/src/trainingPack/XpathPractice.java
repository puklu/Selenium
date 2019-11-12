package trainingPack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class XpathPractice {

	public static void main(String[] args) throws InterruptedException {

System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		
		driver.get("http://newtours.demoaut.com/");
	
		driver.manage().window().maximize();
		
		//using basic xpath///----> //tag[attribute='value']
		driver.findElement(By.xpath("//*[@name='userName']")).sendKeys("user");
		
		
		//using contains
		driver.findElement(By.xpath("//img[contains(@src, \"logo\")]")).click();
		
		//using text()
		driver.findElement(By.xpath("//a[contains(text(), 'Register')]")).click();
		
		Thread.sleep(1000);
		
		////////navigate back to home page//////////////
		/////////////////////////
		driver.navigate().back();
		
		Thread.sleep(1000);
		
		//contains with value attritbute
		driver.findElement(By.xpath("//input[contains(@value, 'Login')]")).click();
		

//        driver.navigate().back();
//		
//		Thread.sleep(1000);
//		
//		driver.findElement(By.xpath("//*[@value='Login']")).click();
		
		
		driver.findElement(By.xpath("//a[contains(text(),'REGISTER')]")).click();
		driver.findElement(By.xpath("//input[@name='firstName']")).sendKeys("Batman");
		driver.findElement(By.xpath("//input[@id='userName']")).sendKeys("bat@abc.xom");
		new Select(driver.findElement(By.xpath("//select[contains(@name, 'country')]"))).selectByValue("230");
		driver.findElement(By.xpath("//*[contains(@id, 'email')]")).sendKeys("bulle@xcv.xcm");
		
		
		
	}

}
