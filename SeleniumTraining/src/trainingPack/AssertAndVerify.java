package trainingPack;

import static org.testng.Assert.*;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssertAndVerify {

	public static void main(String[] args) throws InterruptedException {
		
		    System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
			WebDriver driver = new ChromeDriver();
			
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			
			driver.get("http://zero.webappsecurity.com");
			
			//maximize window
			driver.manage().window().maximize();
			
			String expectedTitle = "Zero - Personal Banking - Loans - Credit Cards";
		    String actualTitle = driver.getTitle();
		    
//	        if(actualTitle.contentEquals(expectedTitle))	{
//	        	System.out.println("title is correct");
//	        }
//	        else {
//	        	System.out.println("what the hell...the title is wrong");;
//	        }
	        
		    
		    //assert
	        assertEquals(expectedTitle, actualTitle);
	        
	        //verification
	        try {
				assertEquals(expectedTitle, actualTitle);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
	        
	        //get text
	        String buttonText = driver.findElement(By.id("signin_button")).getText();
	        assertEquals(buttonText, "Signin");
	        
	        //get attribute
	        String attrValue = driver.findElement(By.xpath("//input[@id='searchTerm']")).getAttribute("class");
	        System.out.println(attrValue);
	        driver.findElement(By.className(attrValue)).sendKeys("text");
	        
	        //get URL
	        String currURL = driver.getCurrentUrl();
	        System.out.println(currURL);
	        
	        driver.navigate().to("http://zero.webappsecurity.com/login.html");
	       
	        Thread.sleep(1000);
	        //checkboxes
	        WebElement chkbox = driver.findElement(By.id("user_remember_me"));
	        chkbox.click();
	        
	        //validate if checkbox selected
	        boolean chkValue = chkbox.isSelected();
 
	        	if(chkValue) {
	        		System.out.println("already checked");
	        	}
	        	else
	        		chkbox.click();
	        
	        //validate if checkbox is enabled
	       boolean chkEnabled = chkbox.isEnabled();
	       System.out.println("enabled? "+chkEnabled);
	       
	       //validating if chkbox is displayed
	       boolean chkDisplayed = chkbox.isDisplayed();
	       System.out.println("displayed? "+ chkDisplayed); 
	        
//	        driver.close();
//	        driver.quit();
	        
	        
	}

}
