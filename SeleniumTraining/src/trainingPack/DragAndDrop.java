package trainingPack;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
	
	static WebDriver driver;
	static int i=0;

	public static void main(String[] args) throws IOException {

System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

		driver.get("https://jqueryui.com/droppable/");
		
		getScreenshot();
		
		Actions act = new Actions(driver);
		
		driver.switchTo().frame(0);
		
		WebElement source = driver.findElement(By.id("draggable"));
	
		WebElement target = driver.findElement(By.id("droppable"));
		
		//click and hold, move and release
        act.clickAndHold(source).moveToElement(target).release().build().perform();
	
        getScreenshot();
	    ///OR
        //Drag and drop method
        act.dragAndDrop(source, target).build().perform();
	
	}
	
	public static void getScreenshot() throws IOException {
		File scrshtFile;
		
		scrshtFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrshtFile, new File("C:\\Users\\VivekPunia\\Documents\\Selenium\\Screenshots\\shot"+ i + ".png"));
		i++;
		
		
	}

}
