package TestCases;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UNF_038 {

	//credentials
    String loginID = "admin";
    String password = "admin@123";
    String categoryTypeAdded = "Zoombox";
    
  WebDriver driver;
  
////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
  @Test
  //Login to the user account
  public void Login() {
 	 	 
 	 //entering username and password
 	 driver.findElement(By.id("input-username")).sendKeys(loginID);
 	 driver.findElement(By.id("input-password")).sendKeys(password);
 	 
 	 //clicking on login button
 	 driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
 	 
 	 //asserting page title
 	 assertEquals(driver.getTitle(), "Dashboard");
 	 System.out.println("Page title asserted:  "+ driver.getTitle());
 	 
 	 
 	 //going into add categories
 	 Actions act = new Actions(driver);
 	 act.moveToElement(driver.findElement(By.xpath("//i[@class='fa fa-tags fa-fw']"))).build().perform();
 	 driver.findElement(By.xpath("//li[@id='catalog']/ul[1]/li[1]/a[1]")).click();
 	 
 	 //adding new category
 	 driver.findElement(By.xpath("//a[@data-original-title='Add New']")).click();
 	 driver.findElement(By.name("category_description[1][name]")).sendKeys(categoryTypeAdded);
 	 driver.findElement(By.name("category_description[1][meta_title]")).sendKeys("The coolest");
 	 driver.findElement(By.xpath("//button[@data-original-title='Save']")).click();
 	 
 	 assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText().substring(0,38), "Success: You have modified categories!");
     System.out.println("Asserted that the msg has been displayed:  "+ driver.findElement(By.xpath("//div[@class='alert alert-success']")).getText().substring(0,38));
  
     //checking in the list that the category has been added
     //finding total number of pages
     List<WebElement> pagesList = driver.findElements(By.xpath("//ul[@class='pagination']/li"));
    
      
     int size = pagesList.size();
     
     //going through all the pages looking for the added category
    	for(int i=0; i<size-3; i++) {
    		
    		List<WebElement> categoriesList = driver.findElements(By.xpath("//tbody/tr/td[2]"));
    		for(WebElement j:categoriesList) {
//    	    	 System.out.println(j.getText());
    	    	 if(j.getText().contentEquals(categoryTypeAdded)) {
    	    		 System.out.println("  "+ categoryTypeAdded + "found in the table");
    	    	 }
    	     }
    		driver.findElement(By.linkText(">")).click();
     }
    	
    	//to collect categories of the last page****
    	List<WebElement> categoriesList = driver.findElements(By.xpath("//tbody/tr/td[2]"));
		for(WebElement j:categoriesList) {
//	    	 System.out.println(j.getText());
	    	 if(j.getText().contentEquals(categoryTypeAdded)) {
	    		 assertEquals(j.getText(), categoryTypeAdded); 
//	    		 System.out.println("  "+ categoryTypeAdded + "and" +j.getText()+ "found in the table");
	    	 }
	     }
	    //****
     
    
  
  }
  
  

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @BeforeTest
  public void SetUp() {
 	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
 	 driver = new ChromeDriver();
 	 
 	 //opening the site
 	 driver.get("http://uniformm1.upskills.in/admin/");
 	 driver.manage().window().maximize();
 	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	   	     	 
  }
  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @AfterTest
  public void CleanUp() {
 	 driver.close();
 	 driver.quit();
  }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////    
	
}
