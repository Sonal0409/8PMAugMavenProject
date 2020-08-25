package com.TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametrizationwithXML {
	
	public static WebDriver driver;
	
@BeforeClass
		public static void setup()
		{
			
	         System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();  // maximize the browser window
			
			driver.manage().deleteAllCookies();  // delete cookies on the browser
			
			driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium		+%28software%29");
			
			}


@Parameters({"Uname","Pword"})
@Test
public void createAccount(String Uname, String Pword) throws InterruptedException
{
	// test steps to perform testcase goes here
	
    
	driver.findElement(By.id("wpName2")).sendKeys(Uname);	
	
	Thread.sleep(3000);
	
	// Inspect password textbox and enter data in the text box
	driver.findElement(By.name("wpPassword")).sendKeys(Pword);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//button[@value='Create your account']")).click();	
	
}


@AfterClass
public void closeBrowser()
{
	driver.close();
}





}
