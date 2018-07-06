/**
 * 
 */
package com.techm.qa.testcases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.techm.qa.controller.Basepage;
import com.techm.qa.pages.HomePage;
import com.techm.qa.pages.Loginpage;
import com.techm.qa.util.TestUtil;
import com.techm.qa.util.Utility;

/**
 * @author Srinidhi
 *
 */
public class HomePageTest extends Basepage {

	Loginpage Loginpage;
	HomePage Homepage;
	TestUtil testUtil;
	
	public HomePageTest()
	{
		super();
	}
	
	
	@BeforeMethod
	public void Setup()
	{
		Initialization();
		Loginpage = new Loginpage();
		Homepage=Loginpage.login(Config.getProperty("username"), Config.getProperty("password"));
		
	}
	
	@Test(priority=2)
	public void VerifyHomepagetitleTest()
	{
	   String Homepagetitle = Homepage.VerifyHomepagetitle();	
	   Assert.assertEquals(Homepagetitle,"CRMPRO");
	   
	}
	
	@Test(priority=1)
	public void VerifyUsername()
	{
//		testUtil=new TestUtil();
		testUtil.switchToframe();
		String Homepageusername = Homepage.validateusername();	
	    Assert.assertEquals(Homepageusername,"  User: Test A");
	   
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
