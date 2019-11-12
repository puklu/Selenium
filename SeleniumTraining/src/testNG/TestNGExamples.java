package testNG;

import org.testng.annotations.*;

public class TestNGExamples {

	@Test(priority =2, groups= {"smoke", "regression"})
	public void testCase1() {
		System.out.println("this is testCase1");
		System.out.println("priority: "+ 2);
	}
	
	
	@Test(priority =3, groups= {"regression"})
	public void testCase2() {
		System.out.println("this is testCase2");
		System.out.println("priority: "+ 3);
	}
	
	@Test(priority =1, groups= {"smoke"})
	public void testCase3() {
		System.out.println("this is testCase3");
		System.out.println("priority: "+ 1);
	}
	
	@BeforeMethod()
	public void beforeMethod() {
		System.out.println("this is before method");
	}
	
	@AfterMethod()
	public void afterMethod() {
		System.out.println("this is after method");
	}
	
	@BeforeTest()
	public void beforeTest() {
		System.out.println("this is before test");
	}
	
	@AfterTest()
	public void afterTest() {
		System.out.println("this is after test");
	}
	
	@BeforeSuite()
	public void beforeSuite() {
		System.out.println("this is before suite");
	}
	
	@AfterSuite()
	public void afterSuite() {
		System.out.println("this is after suite");
	}
}
