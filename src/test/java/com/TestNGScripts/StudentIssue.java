package com.TestNGScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StudentIssue {
	
	WebDriver driver;
	// pass the name of data provide method as parameter to thsi test method
	 
	 @BeforeClass

	 public void startbrowser()
	 {
		 System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (12)\\chromedriver.exe");
			
	 	driver = new ChromeDriver();
	 	driver.manage().window().maximize();
	 	driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium+%28software%29");
	 	
	 }
		 
	
	@Test(dataProvider="readdata")
	public  void wikipagedata(String name, String password, String retype, String email) throws InterruptedException ,NullPointerException
{

	driver.findElement(By.id("wpName2")).clear();
	
	driver.findElement(By.id("wpName2")).sendKeys(name);
	
	Thread.sleep(2000);
	driver.findElement(By.id("wpPassword2")).clear();
	driver.findElement(By.id("wpPassword2")).sendKeys(password);
	Thread.sleep(2000);
	driver.findElement(By.id("wpRetype")).clear();
	driver.findElement(By.id("wpRetype")).sendKeys(retype);
	Thread.sleep(2000);
	driver.findElement(By.id("wpEmail")).clear();
	driver.findElement(By.id("wpEmail")).sendKeys(email);
	

}



@AfterClass
public void closeBrowser() {
	driver.close();
}


@DataProvider(name="readdata")
public Object[][] readxlsx() throws EncryptedDocumentException, IOException 
{
	File fe=new File("C:\\Users\\vishal mittal\\Desktop\\Book1.xlsx");
 FileInputStream f=null;
 f=new FileInputStream(fe);
 Workbook wb=WorkbookFactory.create(f);
 Sheet s=wb.getSheet("Sheet1");
 int rows=s.getLastRowNum();
 int col=s.getRow(0).getLastCellNum();
 System.out.println(rows);
 System.out.println(col);

 String inputData[][]=new String[rows][col];
 for (int i = 0; i < rows; i++) {
		for (int j = 0; j <col; j++)

		{
			inputData[i][j]=s.getRow(i+1).getCell(j).toString();
			

		}
	}

	return inputData;
	
	
}



}





