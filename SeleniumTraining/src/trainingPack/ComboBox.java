package trainingPack;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt.List;

import org.openqa.selenium.*;

public class ComboBox {
	
	static Webdriver driver;

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		
		WebElement mycars = driver.findElement(By.name("cars"));
        Select dropdown = new Select(mycars);  
        
        //dropdown.selectByVisibleText("Mercedes");
        //dropdown.selectByIndex(2);
        
        dropdown.selectByValue("audi");
        List<WebElement> e = dropdown.getOptions();
        
        int itemCount = e.size();
        System.out.println("No of items in the combo box is "+ itemCount);
        
        //iterate through the values and print it
        for(int l = 0; l < itemCount; l++)
        {
            System.out.println(e.get(l).getText());
        }
		
	}

}
