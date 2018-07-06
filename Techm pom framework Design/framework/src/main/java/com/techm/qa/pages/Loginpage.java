/**
 * 
 */
package com.techm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.techm.qa.controller.Basepage;

/**
 * @author Srinidhi
 *
 */
public class Loginpage extends Basepage
{
   @FindBy(name="username")
   WebElement username;
   
   @FindBy(name="password")
   WebElement password;
	
   @FindBy(xpath="//input[@value='Login']")
   WebElement LoginButton;
   
   @FindBy(xpath="//a[contains(text()='Sign Up')]")
   WebElement signup;
   
   @FindBy(xpath="//img[@class='img-responsive']")
   WebElement CRMLogo;
   
   
 // Initializing the Page Objects 
   public Loginpage()
   {
	   PageFactory.initElements(driver, this);
   }
   
 // Actions:
   public String ValidateLoginpagetitle()
   {
	return driver.getTitle();
	
   }
   
   public boolean CRMlogo()
   {
	   return CRMLogo.isDisplayed();
   }
   
   public HomePage login(String Usn,String Pwd)
   {
	   username.sendKeys(Usn);
	   password.sendKeys(Pwd);
	   try {
		Thread.sleep(3000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   LoginButton.click();
	   return new HomePage();
   }
}
