package com.TestNGScripts;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WikiTestCase {
	
	// In TestNG your Test steps for test cases will be written as methods
	// all methods will be void in TestNG except for Data driver
	// TetsNG annotation to execute a test case
	
	// create a method as test case for create account in wiki page
	// A methods used to perform Test case is called a Test Method
	
	// If we have to execute a test method, we will use a TestNG annotation called as @Test
	// Annotation will be written over the method name
	
	// will execute this method in the beginging
	
	// for test case to be executed in correct format or sequence, pls give priority to test case
	
	public static WebDriver driver;
	
	
// @Before class Annotation	
// A method which has before class annotation will get executed as the first method of the class.. only once	
	
	@BeforeClass
	public static void setup()
	{
		
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
		
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();  // maximize the browser window
		
		driver.manage().deleteAllCookies();  // delete cookies on the browser
		
	
		
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium		+%28software%29");
	
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		// implicit wait
		
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		
		
		
	}
	// A method with an annotation @BeforeMethod will get executed before every test method in your class
	
	
	// @BeforeTest and @BeforeSuite  --xml
	
	
	@BeforeMethod
	public void login() throws InterruptedException
	{
		System.out.println("loginto the application, enter username and password");
	}
	
	
	
	//Start execution
	
	
	@Test(priority='1')
	public void createAccount() throws InterruptedException
	{
		// test steps to perform testcase goes here
		
        
		driver.findElement(By.id("wpName2")).sendKeys("Username1");	
		
		Thread.sleep(3000);
		
		// Inspect password textbox and enter data in the text box
		driver.findElement(By.name("wpPassword")).sendKeys("password@123");
		
		WebElement e= driver.findElement(By.xpath("//button[@value='Create your account']"));
		
		// if we add 
	
		Thread.sleep(10000);// waiting until 10 seconds
		
		// instead of this use
		
		// explicit wait
		
				WebDriverWait w= new WebDriverWait(driver, 10); // wait time
				// condition
				  w.until(ExpectedConditions.visibilityOf(e));
		
		
		e.click();	
		
	}
	
	
	@Test(priority='2')
	public void MainPage()
	{
		
		
           driver.findElement(By.linkText("Main page")).click();
		
		// to check if we have landed on the correct page or not?
		
		 System.out.println(driver.getTitle());
	}
	
	// this method will get executed after every test method
	
	@AfterMethod
	public void logout() throws InterruptedException
	{
		System.out.println("logout of the application.");
	}
	
	
	// close my browser, close the server or close tabs
	// @Afterclass annotation is given that method which will be executed after all the test methods will get executed
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
