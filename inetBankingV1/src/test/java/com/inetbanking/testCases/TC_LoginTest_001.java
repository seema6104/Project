package com.inetbanking.testCases;



import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetbanking.pageObjects.LoginPage;



public class TC_LoginTest_001 extends BaseClass{


	@Test
	public void loginTest() {
		driver.get(baseURL);
		
		logger.info("URL is Open");
		
		LoginPage lp = new LoginPage(driver);
		lp.setuserName(username);
		logger.info("UserName is Open!!");
		lp.setPassword(pasword);
		logger.info("Password is entered!!");
		lp.clickSubmit();
		
		if (driver.getTitle().equals("Guru99 Bank Customer HomePage"))
		{
			Assert.assertTrue(true);
	    }
		else 
	{
		Assert.assertTrue(false);
	}
		
	}
}
	
