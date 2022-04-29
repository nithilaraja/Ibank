package com.ibank.Testcases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibank.PageObject.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{

	@Test
	public void Logintest() throws IOException
	{
		
		LoginPage lp=new LoginPage(driver);
		lp.Username(username);
		lp.Password(password);
		lp.login();
		String ae=driver.getTitle();
		System.out.println(ae);
		if (driver.getTitle().equals("GTPL Bank Manager HomePage"))
				{
			Assert.assertTrue(true);
			log.info("Login test passed");
				}
		else
		{
			captureScreen(driver,"Logintest");
			Assert.assertTrue(false);
		}
	}


}
