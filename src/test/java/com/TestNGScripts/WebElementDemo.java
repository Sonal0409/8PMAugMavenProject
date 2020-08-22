package com.TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebElementDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		

System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();  // maximize the browser window
		
		driver.manage().deleteAllCookies();  // delete cookies on the browser
		
		
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium+%28software%29");
		
		
		// Username Text box --sendKeys()
		//isDisplayed()-- output is boolean, it checks if the element is displayed on the page or not
		// isEnabled() ---output is boolean, it checks if the element is enabled or not on the pag
		// sendKeys()
		
		// locator value for Textbox- username
		
	boolean dis=driver.findElement(By.id("wpName2")).isDisplayed(); // true or false
		
		System.out.println(dis);
		
	boolean enb=	driver.findElement(By.id("wpName2")).isEnabled();  // true or false
		
	
	System.out.println(enb);
	
	driver.findElement(By.id("wpName2")).clear(); // clear the data on the text box
	
	driver.findElement(By.id("wpName2")).sendKeys("username2");
	
	Thread.sleep(3000);
	driver.findElement(By.id("wpName2")).clear();
	
	// WEbELement -- it is used to store the location of an element
	
	// Create a webElement
	
	WebElement ele = driver.findElement(By.id("wpPassword2"));
	
	// ele is storing the location of password text box
	
	// any action that we want to perform on password textbox
	//we can use ele object directly.
	
	System.out.println(ele.isEnabled());  // it it is False -- that means element is disbaled
	
	System.out.println(ele.isDisplayed());
	
	ele.clear();
	
	ele.sendKeys("password");
	
	Thread.sleep(3000);
	
	ele.clear();
	
	WebElement be= driver.findElement(By.id("wpCreateaccount"));
	
	// store it in a webElement object and than perform actions on the element
	
	be.isDisplayed();
	be.isEnabled();
	be.click();
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
