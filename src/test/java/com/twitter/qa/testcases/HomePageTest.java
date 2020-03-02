/*
 * Auther: Anuradha Rathnayake
 * Test Cases relevant to Home Page class are being written here.
 * 
*/

package com.twitter.qa.testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.twitter.qa.base.TestBase;
import com.twitter.qa.scenarios.HomePage;
import com.twitter.qa.scenarios.LoginTwitter;

public class HomePageTest extends TestBase{
	
	//Class variables
	HomePage homePage;
	LoginTwitter loginPage;

	
	//Calls the super class constructor: TestBase()
	public HomePageTest() {
		super();
	}
	
	
	//Initialize the browser, load the URL and logging in to the system
	//Annotation indicates that these are "preconditions" for the @Test method
	@BeforeMethod
	public void setUp(){
		Initialization();
		loginPage = new LoginTwitter();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	
	//Test methods for each test case
	/*
	 * Annotation indicates that this is the actual test method 
	and given the highest sequential priority
	
	*/
	@Test(priority=1)
	public void verifyCreateTweet(){
		homePage.validateBtnMainTweet();
		homePage.validateTwitterTextArea();
		homePage.validatebtnPublishTweet();
	}
	
	@Test(priority=2)
	public void verifyTwitterLike(){
		homePage.validateTwitterLike();
	}
	
	@Test(priority=3)
	public void verifyTwitterReply(){
		homePage.validateTwitterReply();
	}
	
	//Below test method has given the lowest sequential priority
	@Test(priority=4)
	public void verifyDeletePost(){
		homePage.validateDeletePost();
	}

	
	
	//Runs the code block after executing the test methods
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	

}
