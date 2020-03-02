/*
 * Auther: Anuradha Rathnayake
 * Page class for Home Page that contains all the web elements,
 * action methods, class properties and page features
*/

package com.twitter.qa.scenarios;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.twitter.qa.base.TestBase;
import com.twitter.qa.util.TestUtil;

public class HomePage extends TestBase{
	
		
		//Twitter Main Page factory/Object Repository
		@FindBy(xpath="//span[contains(text(),'Tweet')]")
		WebElement btnMainTweet;
		
		@FindBy(xpath="//div[contains(text(),'What’s happening?')]//parent::div//parent::div//div[2]//div//div//div//div")
		WebElement twitterTextArea;
		
		@FindBy(xpath="//div[@data-testid='tweetButton']//div//span//span")
		WebElement btnPublishTweet;
		
		@FindBy(xpath="//span[contains(text(),'Test tweet by test_user_2')]")
		WebElement tweeterPostUser2;
		
		@FindBy(xpath="//div[@aria-label='Like']//div[@dir='ltr']")
		WebElement btnLike;
		
		@FindBy(xpath="//div[@aria-label='Reply']//div[@dir='ltr']")
		WebElement btnReply;
		
		@FindBy(xpath="//div[contains(text(),'Tweet your reply')]//parent::div//parent::div//div[2]//div//div//div//div")
		WebElement replyTextArea;
		
		@FindBy(xpath="//div[@data-testid='tweetButton']//div")
		WebElement btnPostReply;
		
		@FindBy(xpath="//span[contains(text(),'This Post will be DELETED!!')]")
		WebElement tweeterPostUser1;
		
		@FindBy(xpath="//article//div//div[2]//div[@aria-label='More']")
		WebElement btnMore;
		
		@FindBy(xpath="//span[contains(text(),'Delete')]")
		WebElement btnDelete;
		
		@FindBy(xpath="//span[contains(text(),'Delete Tweet?')]//parent::div//parent::div//div[3]//div//span[contains(text(),'Delete')]")
		WebElement btnConfirmDelete;
		
		
		
		//Constructing and initializing Home Page object
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
	
	
		
		//Actions relevant to Home page
		public void validateBtnMainTweet() {
			btnMainTweet.click();
		}
		
		public void validateTwitterTextArea() {
			twitterTextArea.sendKeys("This is a auotomated twitter Post!!");
		}
		
		public void validatebtnPublishTweet() {
			btnPublishTweet.click();
		}
		
		public void validateTwitterLike() {
			tweeterPostUser2.click();
			btnLike.click();
		}
		
		public void validateTwitterReply() {
			tweeterPostUser2.click();
			btnReply.click();
			replyTextArea.sendKeys("This is the automated reply!!");
			btnPostReply.click();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		}
		
		public void validateDeletePost() {
			tweeterPostUser1.click();
			btnMore.click();
			btnDelete.click();
			btnConfirmDelete.click();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		}
		
		

}
