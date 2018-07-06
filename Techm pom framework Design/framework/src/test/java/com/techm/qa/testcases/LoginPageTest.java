/**
 * 
 */
package com.techm.qa.testcases;

import java.io.IOException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.techm.qa.controller.Basepage;
import com.techm.qa.pages.*;
import com.techm.qa.pages.HomePage;
import com.techm.qa.pages.Loginpage;
import com.techm.qa.util.Utility;

import junit.framework.Assert;

/**
 * @author Srinidhi
 *
 */
public class LoginPageTest extends Basepage{
	Loginpage Loginpage;
	HomePage Homepage;
	
	public LoginPageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup()
	{
		Initialization();
		Loginpage = new Loginpage();
		
	}
	
	@Test(priority=1)
	public void loginpagetitleTest()
	{
		String actualtitle = Loginpage.ValidateLoginpagetitle();
		String Expectedtitle="Free CRM software in the cloud powers sales and customer service";
		Assert.assertEquals(Expectedtitle,actualtitle);
	}
	
	@Test(priority=2)
	public void loginpagelogoimagetest()
	{
		boolean flag = Loginpage.CRMlogo();
		Assert.assertTrue(flag);
	}
	
	@Test(priority=3)
	public void logintest()
	{
	  	 Homepage = Loginpage.login(Config.getProperty("username"), Config.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown(ITestResult result) throws IOException
	{
		
		if(result.getStatus()==ITestResult.FAILURE)
		{
			String temp=Utility.getScreenshot(driver);
//			String image= logger.addScreenCapture(temp);
//			logger.log(LogStatus.FAIL, "Title verification", image);
		}
	    driver.quit();
		
	}
	
}
