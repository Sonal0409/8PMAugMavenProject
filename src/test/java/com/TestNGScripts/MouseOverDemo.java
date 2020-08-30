package com.TestNGScripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MouseOverDemo {
	
	public static WebDriver driver;
	
	
	
		@BeforeClass
		public static void setup()
		{
			
	         System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
			
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();  // maximize the browser window
			
			driver.manage().deleteAllCookies();  // delete cookies on the browser
			
			driver.get("https://www.amazon.com/");
			
		}
		
		
		public void mouseovermethod() throws InterruptedException
		{
			
			
			WebElement e=driver.findElement(By.id("nav-link-accountList"));
			
			// mouseover-- to move to an element moveToElement(), build , perform
			
			Actions obj= new Actions(driver);
			
			obj.moveToElement(e).build().perform();
			
			Thread.sleep(2000);
			
			// inspect one of the links and click on it
			
			driver.findElement(By.xpath("//*[@id=\"nav-al-wishlist\"]/a[4]/span")).click();
		}
		
		
	@Test
	public void dragandDropmethod() throws InterruptedException
	{
		driver.navigate().to("https://jqueryui.com/droppable/");

		driver.switchTo().frame(0);
		
		
		WebElement e= driver.findElement(By.id("draggable"));

		WebElement e1= driver.findElement(By.id("droppable"));
		
		
		Actions obj = new Actions(driver);
		// drag and drop

		// click an hold for sometime on the element to be moved to another location, release, build and perform
// clickAndHold() --event:  it will click on an element and hold it for certain time
		// MoveToElement() --Event : move the cursor to an or another element
		// build() and perform() methods are used to perform the series of events on the page
		obj.clickAndHold(e).moveToElement(e1).build().perform();
		
		Thread.sleep(3000);
		driver.navigate().refresh();
		
		//double click
        
		
		//obj.doubleClick(e).build().perform();
		
		
//right click on an element
		driver.switchTo().defaultContent();
		WebElement e2= driver.findElement(By.linkText("Droppable"));
		
		obj.contextClick(e2).build().perform();
		


	}
		
		
		
		
		
		

}
