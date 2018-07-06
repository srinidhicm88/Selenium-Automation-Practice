/**
 * 
 */
package com.techm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.techm.qa.controller.Basepage;

/**
 * @author Srinidhi
 *
 */
public class HomePage extends Basepage{

	@FindBy(xpath="//td[contains(text(),'User: Test A')]")
	WebElement username;

    @FindBy(xpath="//a[contains(text(),'Contacts')]")
    WebElement Contactslink;
    
    @FindBy(xpath="//a[contains(text(),'Deals')]")
    WebElement Dealslink;
    
    @FindBy(xpath="//a[contains(text(),'Tasks')]")
    WebElement Taskslink;
    
    
 // Initializing the Page Objects 
    public HomePage()
    {
 	   PageFactory.initElements(driver, this);
    }
    
    //Action:validate the name of the user
    public String VerifyHomepagetitle()
    {
    	return driver.getTitle();
    }
    
    
    public String validateusername()
    {
    	return username.getText();
    }
    
    
    
    public Contactpage clickonContactslink()
    {
    	Contactslink.click();
    	return new Contactpage();
    }
    public Dealspage clickonDealslink()
    {
    	Dealslink.click();
    	return new Dealspage();
    }
    public Taskpage clickonTasklink()
    {
    	Dealslink.click();
    	return new Taskpage();
    }
    
}
