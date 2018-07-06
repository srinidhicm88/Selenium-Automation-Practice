package com.techm.qa.controller;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.techm.qa.util.TestUtil;

public class Basepage 
{
 
    public static WebDriver driver= null;
	public static Properties Config = null;
	public static Properties OR = null;
	public ExtentReports reports;
	public ExtentTest Logger;
	   public Basepage()
	   {
		   if(driver==null)
	       {
		  	
			   
			   //initialize the property file.
			Config = new Properties();
			OR = new Properties();   
			System.out.println(System.getProperty("user.dir"));
			String path = System.getProperty("user.dir")+"\\src\\main\\java\\com\\techm\\qa\\config\\config.properties";
			String opath = System.getProperty("user.dir")+"\\src\\main\\java\\com\\techm\\qa\\config\\OR.properties";
			System.out.println(path);
			System.out.println(opath);
				try
				{
				    //Load URL file
					FileInputStream fs =new FileInputStream(path);
					Config.load(fs);
				    
				    //Load Object Repository file
				    FileInputStream ofs =new FileInputStream(opath);
				    OR.load(ofs);
				 
				}
				catch(Exception E)
				{
					return;
				}
		 
		 }	
	   }	   
		public void Initialization(){
		if(Config.getProperty("browser").equals("Mozilla"))
			{
				  System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir")+"\\BrowserExtensionsfiles\\geckodriver.exe");
				  driver = new FirefoxDriver();
				  driver.manage().deleteAllCookies();
//				System.out.println(Config.getProperty("browser"));
			}	     
			else if(Config.getProperty("browser").equals("IE"))
			{
				  System.setProperty("webdriver.ie.driver",System.getProperty("user.dir")+"\\BrowserExtensionsfiles\\IEDriverServer.exe");
				  driver = new InternetExplorerDriver();
				  driver.manage().deleteAllCookies();
			}
			else if(Config.getProperty("browser").equals("Chrome"))	
			{
				  System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\BrowserExtensionsfiles\\chromedriver.exe");
				  driver = new ChromeDriver();
				  driver.manage().deleteAllCookies();
			}
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		  
			driver.get(Config.getProperty("url"));
	  }
	   
	
//		public void waitforsometime()
//		{
//		  driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
//			
//		}
		
		//Click operation
		public void Click(String xpathKey)
		{		
			try
			{
				driver.findElement(By.xpath(OR.getProperty(xpathKey))).click();
			}
			catch(Exception e)
			{
				System.out.println("Error in click");
			}
		}
		
		public void xpath(String xpathkeys)
		{
			try
			{
				driver.findElement(By.xpath(OR.getProperty(xpathkeys)));
			}
			catch(Exception e)
			{
				System.out.println("Error in Xpath");
			}
		}
		
		public void ID(String ID)
		{
			try
			{
				driver.findElement(By.xpath(OR.getProperty(ID)));
			}
			catch(Exception e)
			{
				System.out.println("Error in identification of IDs");
			}
		}
		
		//Input
		public void Input(String xpath,String Text)
		{
			try
			{
				driver.findElement(By.xpath(OR.getProperty(xpath))).sendKeys(OR.getProperty(Text));
			}
			catch(Exception e)
			{
				System.out.println("Error in Input");
			}
		}
		
		//Verification
		public boolean IsElementpresent(String xpath)
		{
			try
			{
				driver.findElement(By.xpath(OR.getProperty(xpath)));
			}
			catch(Exception e)
			{
				return false;
			}
			return true;
		}
}
