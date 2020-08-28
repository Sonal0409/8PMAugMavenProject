package com.TestNGScripts;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.utility.Xls_dataProvider;

public class ParameterizationwithPOI {
	
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
			 
			@Test(dataProvider="testdata")
			public  void wikipagedata(String name, String password, String retype, String email)
			{
				driver.findElement(By.id("wpName2")).clear();
				
				driver.findElement(By.id("wpName2")).sendKeys(name);
				
				
				driver.findElement(By.id("wpPassword2")).clear();
				driver.findElement(By.id("wpPassword2")).sendKeys(password);
				driver.findElement(By.id("wpRetype")).clear();
				driver.findElement(By.id("wpRetype")).sendKeys(retype);
				driver.findElement(By.id("wpEmail")).clear();
				driver.findElement(By.id("wpEmail")).sendKeys(email);
			}
			
			
			
			@DataProvider(name="testdata")
			public Object[][] readExcel2()
			{
				Object input[][] =Xls_dataProvider.getTestData("Sheet1");
			return input;
			}
			
			
			
			
			
			
			
		// Apache POi
	
			public Object[][] readExcel() throws EncryptedDocumentException, IOException
			{
				
		// provide the location of file
				
		FileInputStream f= new 	FileInputStream("C:\\Users\\vishal mittal\\Desktop\\testdata.xlsx");
		
		// fetch the workbook from the location above
		
		
	Workbook book =WorkbookFactory.create(f);
	
	// ftech the sheet which has data
	
       Sheet s	 =book.getSheet("Sheet1");
  
       // fetch the  rows and columns   
       
     int rows=  s.getLastRowNum();
      
     // fecth the columns
      int col   = s.getRow(0).getLastCellNum();
     
       String input[][]= new String [rows][col];
       
       for(int i=1; i<rows;i++)
       {
    	   for(int j=0; j<col;j++)
    	   {
    		   input[i][j]=s.getRow(i).getCell(j).toString();
    	   }
       }
    		   
       return input;
       
       
       
       
       
       
       
       
       
       
       
       
	
	
	
	
	
	
	
	
	
		
				
				
				
				
				
				
				
				
				
				
				
			}
			
			
			
			
			
			

}
