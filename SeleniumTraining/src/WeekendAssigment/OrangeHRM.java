package WeekendAssigment;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class OrangeHRM {

	
		
		WebDriver driver;
		
		
		@BeforeTest
		public void setUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\VivekPunia\\\\Documents\\\\Selenium\\\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		
	    }
		
	
		
		@Test
		public void test() {
		////////  clicking on linkedIn ///////
		driver.findElement(By.xpath("//img[@alt='LinkedIn OrangeHRM group']")).click();
		Set<String> handlesLi = driver.getWindowHandles();
//		System.out.println(handlesLi);
//		driver.switchTo().window(handlesLi);
		
		Iterator<String> it=handlesLi.iterator();
		
		String mainWindowLi = it.next();
		String childWindowLi = it.next();
		
//		System.out.println("main: "+mainWindowLi+ "   " + "child" + childWindowLi);
		
		driver.switchTo().window(childWindowLi);
		System.out.println("Child window title: " + driver.getTitle());
		driver.close();
		driver.switchTo().window(mainWindowLi);
		System.out.println("main window title: " + driver.getTitle());
		
		
		////Clicking on facebook //////
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on Facebook']")).click();
		Set<String> handlesFB = driver.getWindowHandles();
//		System.out.println(handlesFB);
//		driver.switchTo().window(handlesFB);
		
		Iterator<String> itFB=handlesFB.iterator();
		
		String mainWindowFB = itFB.next();
		String childWindowFB = itFB.next();
		
//		System.out.println("main: "+mainWindowFB+ "   " + "child" + childWindowFB);
		
		driver.switchTo().window(childWindowFB);
		System.out.println("Child window title: " + driver.getTitle());
		driver.close();
		driver.switchTo().window(mainWindowFB);
		System.out.println("main window title: " + driver.getTitle());
		
		
		///// Clicking on twitter//////
		driver.findElement(By.xpath("//img[@alt='OrangeHRM on twitter']")).click();
		Set<String> handlesTW = driver.getWindowHandles();
		Iterator<String> itTW= handlesTW.iterator();
		
		String mainWindowTW = itTW.next();
		String childWindowTW = itTW.next();
		
		driver.switchTo().window(childWindowTW);
		System.out.println("Child window title: " + driver.getTitle());
		driver.close();
		driver.switchTo().window(mainWindowTW);
		System.out.println("main window title: " + driver.getTitle());
		
	///// Clicking on youtube//////
			driver.findElement(By.xpath("//img[@alt='OrangeHRM on youtube']")).click();
			Set<String> handlesYT = driver.getWindowHandles();
			Iterator<String> itYT= handlesYT.iterator();
			
			String mainWindowYT = itYT.next();
			String childWindowYT = itYT.next();
			
			driver.switchTo().window(childWindowYT);
			System.out.println("Child window title: " + driver.getTitle());
			driver.close();
			driver.switchTo().window(mainWindowYT);
			System.out.println("main window title: " + driver.getTitle());
		
	}	
			
     @AfterTest
     public void cleanUp() {
     driver.close();
     driver.quit();
     }	
	

}
