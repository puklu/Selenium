package TestCode;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login_steps {

	public static WebDriver driver;
	
	@Given("^An application$")
	public void OpenBrowser() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\VivekPunia\\Documents\\Selenium\\chromedriver.exe");		
	    driver = new ChromeDriver();		
	    driver.get("http://zero.webappsecurity.com/index.html");
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("signin_button")).click();
//		
//		
//		
		
	}
	
	@Given("^valid username$")
	public void username() {}
	
	@Given("^valid password$")
	public void password() {}
	
	@When("^i enter username as \"([^\"]*)\"$")
	public void enterUsername(String username) {
		driver.findElement(By.name("user_login")).sendKeys("username");
	}
	
	@When("^i enter password as \"([^\"]*)\"$")
	public void enterPassword(String password) {
		driver.findElement(By.name("user_password")).sendKeys("password");
	}
	
	@When("^i click on \"sign in\" button$")
	public void clickLogInButton() {
		driver.findElement(By.name("submit")).click();
	}
	
	@Then("^I should be able to login$")
	public void validateHomePage() {
		assertEquals("Zero - Account Summary", driver.getTitle());
	}
	
//	@Then("^I should be able to login$")
//	public void validateErrorMsg() {
//		
//		assertEquals("Zero - Account Summary", driver.getTitle());
//	}
	
	
		
}
