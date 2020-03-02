/*
 * Auther: Anuradha Rathnayake
 * 
 * This is the base class; the parent class for 
 * all the page and test classes inside the framework
*/

package com.twitter.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


import com.twitter.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	
	
	//TestBase constructor
	public TestBase() {
		
		
		//Obtain configurations from property file
		prop = new Properties();
		try {
			FileInputStream propFile = new FileInputStream("src/main/java/com/twitter/qa/config/config.properties");
			prop.load(propFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	//Initialize preferred web browser and load the URL to begin with
	public static void Initialization(){
		
		String browserName = prop.getProperty("browser");
		
		if (browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver\\chromedriver.exe");
			
			driver = new ChromeDriver();
		}
		else if (browserName.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver", "drivers\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(prop.getProperty("url"));
		
		//Click on the login button in the main twitter page and redirect the user to login page
		WebElement mainLoginBtn = driver.findElement(By.xpath("//span[contains(text(),'Log in')]"));
		mainLoginBtn.click();		
	}


}
