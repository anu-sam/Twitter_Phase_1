/*
 * Auther: Anuradha Rathnayake
 * Test Cases relevant to Login Page class are being written here.
 * 
*/

package com.twitter.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.twitter.qa.base.TestBase;
import com.twitter.qa.scenarios.HomePage;
import com.twitter.qa.scenarios.LoginTwitter;

public class LoginPageTest extends TestBase {
	
	//Class variables
	LoginTwitter loginPage;
	HomePage homePage;
	
	
	//Calls the super class constructor: TestBase()
	public LoginPageTest() {
		super();		
	}
	
	
	//Initialize the browser, load the URL and logging in to the system
	//Annotation indicates that these are "preconditions" for the @Test method
	@BeforeMethod
	public void setUp(){
		Initialization();
		loginPage = new LoginTwitter();
	}
	
	
	//Test methods for the login test case
	@Test
	public void verifyLogin(){
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	//Runs the code block after executing the test methods
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
