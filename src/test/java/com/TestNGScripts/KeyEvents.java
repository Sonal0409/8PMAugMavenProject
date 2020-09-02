package com.TestNGScripts;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class KeyEvents {
	
	@Test
	public void Keyevenetsmethod() throws AWTException, InterruptedException
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
		
		// Open a new tab and Switching between the tabs 
		
		WebDriver driver;
		
		driver= new ChromeDriver();
		
driver.get("https://selenium.dev/selenium/docs/api/java/index.html");
		
		Robot robot = new Robot();   
		
		//sendKeys()
		// keyPress  and keyRelease from keyboard
		
		// to open new tabs in window  -- 2 tabs
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_T);
		
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_T);
		robot.keyPress(KeyEvent.VK_CONTROL); 
		robot.keyPress(KeyEvent.VK_T); 
		robot.keyRelease(KeyEvent.VK_CONTROL); 
		robot.keyRelease(KeyEvent.VK_T);
		
		//robot.keyPress(KeyEvent.VK_META);
		
		Thread.sleep(2000);
		
		// Capture all the tabs that are open on a browser window --getWindowHandles() method is used
	
		
		// Use method getWindowHandles()
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		Thread.sleep(2000);
		System.out.println(tabs);
		
		driver.switchTo().window(tabs.get(1));
		
		driver.get("https://selenium.dev/selenium/docs/api/java/index.html");
		
		
		driver.switchTo().window(tabs.get(2));
		
		driver.get("https://jqueryui.com/droppable/");
		
		//driver.quit();
		
		
		

	}

}
