/*
 * Auther: Anuradha Rathnayake
 * Page class for Login Page that contains all the web elements,
 * action methods, class properties and page features
*/

package com.twitter.qa.scenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.twitter.qa.base.TestBase;
import com.twitter.qa.scenarios.HomePage;

public class LoginTwitter extends TestBase {
	
	//Twitter Login Page factory/Object Repository
	@FindBy(xpath="//span[contains(text(),'Phone, email, or username')]//parent::div//parent::div//div[2]//div//input")
	WebElement username;
	
	@FindBy(xpath="//span[contains(text(),'Password')]//parent::div//parent::div//div[2]//div//input")
	WebElement password;
	
	@FindBy(xpath="//span[contains(text(),'Forgot password')]//parent::a//parent::div//parent::div//parent::div//form//div[3]"
			+ "//div[@role='button']//div")
	WebElement loginBtn;

	
	
	//Constructing and initializing Login Page object
	public LoginTwitter() {
		PageFactory.initElements(driver, this);
	}
	
	
	
	//Actions relevant to Login Page
	public HomePage login(String loginname, String pwd){
		username.sendKeys(loginname);
		password.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
	

}
