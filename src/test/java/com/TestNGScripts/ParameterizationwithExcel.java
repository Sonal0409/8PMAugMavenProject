package com.TestNGScripts;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ParameterizationwithExcel {
	
	 WebDriver driver;
	
		 
		 @BeforeClass

		 public void startbrowser()
		 {
			 System.setProperty("webdriver.chrome.driver", "C:\\Users\\vishal mittal\\Downloads\\chromedriver_win32 (10)\\chromedriver.exe");
		 	driver = new ChromeDriver();
		 	driver.manage().window().maximize();
		 	driver.get("https://en.wikipedia.org/w/index.php?title=Special:CreateAccount&returnto=Selenium+%28software%29");
		 	
		 }
		 
		 
		@Test(dataProvider="inputData")
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
		
		
		// Data Provider method-- return data from excel and pass it on to test method
		
		@DataProvider(name="inputData")
		public Object[][] readExcel() throws BiffException, IOException
		{
			// provide the location of your excel sheet
		File f= new File("C:\\Users\\vishal mittal\\Desktop\\input.xls");	
		
		// fetch the excel from above provided location and store it an object
		// added a jxl jar file to my project
		// these classes are part of jxl
		
		Workbook w	=Workbook.getWorkbook(f);
	
		Sheet s=w.getSheet("Sheet1");  // sheet in which we have data
		
		//fecth number of rows in sheet 1 which has data
		//fecth number of columns in sheet 1 which has data
		int rows= s.getRows();
		int col = s.getColumns();
		
		// go to each row, its each column and fetch the data from cell
		
		// Declare an array which will store the data fetched from row and colms
		
		String inputData[][] = new String [rows][col];
		
		// for loop to go to each row
		 for(int i=0;i<rows;i++)
		 {
			 for(int j=0;j<col;j++) {
				 
				 // fetch the data from each cell of that row
				
				 // fetching the cell
				Cell c= s.getCell(j, i) ;
				 
				inputData[i][j] =c.getContents();
				 
				 }
			
		 }
		 return inputData;	
				}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}
