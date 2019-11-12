import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Grid {
	
	public static WebDriver driver;
	static String URL = "https://opensource-demo.orangehrmlive.com/";
	
	public static void main(String[] args) {
		String Node = "http://192.168.1.157:4646/wd/hub";
		
		DesiredCapabilities cap = DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WIN10);
		
		driver = new RemoteWebDriver(new URL(Node), cap);
		
		driver.navigate().to(URL);
		Thread.sleep(5000);
		driver.quit();
		
		
	}

}
