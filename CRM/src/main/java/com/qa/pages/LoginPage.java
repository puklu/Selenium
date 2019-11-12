package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//page factory -OR:
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//button[conatins(text(), 'Sign Up)")
	WebElement signUpBtn;
	
	@FindBy(xpath="//img[contains(@class, ' img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
    
	//actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
    
	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		username.sendKeys(un);
		password.sendKeys(pwd);
		
		loginBtn.click();
//		JavascriptExecutor js = (JavascriptExecutor)driver;
//		js.executeScript("arguments[0].click()");
		return new HomePage(); 
	}
	
	
	
	
}
