package com.hybridFramework.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hybridFramework.pageObjects.LoginPage;


public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void loginTest() throws IOException 
	{
			
		logger.info("URL is opened");
		
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		logger.info("Entered username");
		
		lp.setPassword(password);
		logger.info("Entered password");
		
		captureScreen(driver,"loginTest");
		
		lp.clickSubmit();
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		if(isAlertPresent()==true)
		{
			captureScreen(driver,"loginTest");
			driver.switchTo().alert().accept();//close alert
			driver.switchTo().defaultContent();
			Assert.assertTrue(true);
			logger.warn("Incorrect Uname & Password");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Login Successfull");
		}
//		if(driver.getTitle().equals("Guru99 Bank Home Page"))
//		{
//			Assert.assertTrue(true);
//			logger.info("Login test passed");
//		}
//		else
//		{
//			//captureScreen(driver,"loginTest");
//			Assert.assertTrue(false);
//			logger.info("Login test failed");
//		}
		
	}
}