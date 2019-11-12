package trainingPack;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class MultipleBrowsers {

	public static void main(String[] args) throws Exception {

      WebDriver driver;
      
      
      String browser = "chrome";
      
      if(browser.equalsIgnoreCase("chrome")) {
    	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
			
		  driver = new ChromeDriver();
			
      }
      else if (browser.equalsIgnoreCase("firefox")) {
    	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\geckodriver.exe");
			
		  driver = new FirefoxDriver();
		
      }
      else if (browser.equalsIgnoreCase("ie")) {
    	  System.setProperty("webdriver.ie.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\IEDriverServer.exe");
			
		  driver = new InternetExplorerDriver();
		
      }
      else {
    	  throw new Exception("Browser is not set");
      }
      
      driver.get("http://newtours.demoaut.com");
	}

}
