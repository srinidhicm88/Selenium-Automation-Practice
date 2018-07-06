/**
 * 
 */
package com.techm.qa.util;

import java.util.concurrent.TimeUnit;

import com.techm.qa.controller.Basepage;

/**
 * @author Srinidhi
 *
 */
public class TestUtil extends Basepage{
	
	public static long PAGE_LOAD_TIMEOUT=60;
	public static long IMPLICIT_WAIT=40;

	
	public static void switchToframe()
	{
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT,TimeUnit.SECONDS);
		driver.switchTo().frame("mainpanel");
	}
	
}
