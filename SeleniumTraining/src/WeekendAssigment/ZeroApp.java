package WeekendAssigment;

import static org.testng.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public class ZeroApp {

	static WebDriver driver;
//	public static void main(String[] args) {
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@BeforeTest
	public void SetUp() {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://zero.webappsecurity.com/index.html");
		driver.manage().window().maximize();
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@AfterTest
	public void CleanUp() {
		driver.close();
		driver.quit();
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void TestCase() {
		
		Actions action = new Actions(driver);
		
		//login
		driver.findElement(By.id("signin_button")).click();
		driver.findElement(By.id("user_login")).sendKeys("username");
		driver.findElement(By.id("user_password")).sendKeys("password");
		driver.findElement(By.name("submit")).click();
		// try to use ENTER here later
		
		///// 1. Going to account summary tab /////
		driver.findElement(By.xpath("//a[contains(text(), 'Account Summary')]")).click();
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		
		//printing the text of all the links
		for(WebElement li: listOfLinks) {
			System.out.println(li.getText());
		}
		
//		//clicking on all the links
		 {
		for(WebElement li: listOfLinks) 
			if(!li.getText().equals("Zero Bank") | !li.getText().equals("Settings") | !li.getText().equals("username") | li.getText()!=null ) {
			li.click();
			driver.navigate().back();
			}
			WebDriverWait ewait = new WebDriverWait(driver, 10);
			ewait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[contains(text(),'Cash Accounts')]")));
		
		}
		
		
		////// 2. Going to account activity tab /////
		driver.findElement(By.linkText("Account Activity")).click();
		new Select(driver.findElement(By.id("aa_accountId"))).selectByVisibleText("Checking");
		
		//verifying content
//		try {
//			assertEquals(driver.findElement(By.xpath("//div[@id='all_transactions_for_account']//tbody/tr[1]/td[2]")), "CHECK DEPOSIT");
//			assertEquals(driver.findElement(By.xpath("//div[@id='all_transactions_for_account']//tbody/tr[2]/td[2]")), "TELECOM");
//			assertEquals(driver.findElement(By.xpath("//div[@id='all_transactions_for_account']//tbody/tr[3]/td[2]")), "CAR PAYMENT");
//		} catch (Error e) {
//             //e.printStackTrace();
//			System.out.println("table contents are NOT what is expected");
//		}
		
		////// 3.Going to Pay Bills //////
		driver.findElement(By.cssSelector("li#pay_bills_tab")).click();
		driver.findElement(By.cssSelector("a[href='#ui-tabs-2']")).click();
		driver.findElement(By.cssSelector("input#np_new_payee_name")).sendKeys("Batman");
		driver.findElement(By.cssSelector("textarea#np_new_payee_address")).sendKeys("Gotham");
		driver.findElement(By.cssSelector("input#np_new_payee_account")).sendKeys("6969");
		driver.findElement(By.cssSelector("input#np_new_payee_details")).sendKeys("Catwoman");
		driver.findElement(By.cssSelector("input.btn-primary")).click();
		
		////// 4. Pay Bills -> Purchase foreign currency ///////
		driver.findElement(By.xpath("//a[contains(text(), 'Purchase Foreign Currency')]")).click();
		new Select(driver.findElement(By.xpath("//select[@id='pc_currency']"))).selectByVisibleText("China (yuan)");
		driver.findElement(By.xpath("//input[@id='pc_amount']")).sendKeys("44");
		driver.findElement(By.xpath("//label[@class='radio inline']/input[@id='pc_inDollars_false']")).click();
		driver.findElement(By.xpath("//input[@id='pc_calculate_costs']")).click();
		driver.findElement(By.xpath("//input[@value='Purchase']")).click();
		
		////// 5. Going to money map //////
		driver.findElement(By.xpath("//li[@id='pay_bills_tab']//following::li")).click();
//		action.moveToElement(driver.findElement(By.xpath(""))).click().build().perform();
		driver.findElement(By.xpath("//*[@id='ext-sprite-1271']")).click();
		
		// CANT LOCATE ELEMENTS   i used
	/// it is all svg elements
		
		
//	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	}
}
