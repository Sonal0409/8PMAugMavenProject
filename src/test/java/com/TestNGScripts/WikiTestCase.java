package com.TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
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
		
		
	}
	
	
	
	
	
	
	//Start execution
	
	
	@Test(priority='2')
	public void createAccount() throws InterruptedException
	{
		// test steps to perform testcase goes here
		
        
		driver.findElement(By.id("wpName2")).sendKeys("Username1");	
		
		Thread.sleep(3000);
		
		// Inspect password textbox and enter data in the text box
		driver.findElement(By.name("wpPassword")).sendKeys("password@123");
		driver.findElement(By.xpath("//button[@value='Create your account']")).click();	
		
	}
	
	
	@Test(priority='3')
	public void MainPage()
	{
		
		
           driver.findElement(By.linkText("Main page")).click();
		
		// to check if we have landed on the correct page or not?
		
		 System.out.println(driver.getTitle());
	}
	
	
	
	// close my browser, close the server or close tabs
	// @Afterclass annotation is given that method which will be executed int he end
	@AfterClass
	public void closebrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
