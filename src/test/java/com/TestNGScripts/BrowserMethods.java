package com.TestNGScripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();  // maximize the browser window
		
		driver.manage().deleteAllCookies();  // delete cookies on the browser
		
		driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium+%28software%29");
		
		// Fetch the Application Title (getTitle()) and URL( getCurrentURL() ), and store in a variable(String)
		
		//verify the actual title(String) with the expected title(String) -- equals() or contains()
		
		
	String actualtitle	=driver.getTitle();   // return the title of the webpage
		
	
	
	
		if(actualtitle.equals("Create account - Wikipedia"))
		{
			System.out.println("Title of the webpage is correct : " + actualtitle);
		}
		else
		{
			System.out.println("Title of the webpage is incorrect : ");
			System.out.println("The correct title should be : " + "Create account - Wikipedia");
		}
		
	String actualurl= driver.getCurrentUrl();	
		
	
	if(actualurl.contains("Special:CreateAccount"))
		
	{
		System.out.println("URL of the webpage is correct : " + actualurl);
	}
	else
	{
		System.out.println("url of the webpage is incorrect : ");
		System.out.println("The correct url should contain : " + "Special:CreateAccount");
	}
	
		
	// browser Naviagtion methods	
	
	driver.navigate().to("https://en.wikipedia.org/wiki/Main_Page");
		
	
	System.out.println(driver.getCurrentUrl())	;
		
	System.out.println(driver.getTitle())	;	
	
	
	driver.navigate().back();
	
	System.out.println("Navigate back to previous page : " + driver.getTitle())	;
	
	Thread.sleep(3000);
	
	driver.navigate().forward();
	
	System.out.println("Navigate forward to next page : " + driver.getTitle())	;
	
	Thread.sleep(3000);
	
	driver.navigate().refresh();
	
	
	
	
	
	
	
	
	
	
	
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
