package com.ibank.Testcases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.ibank.PageObject.LoginPage;
import com.ibank.PageObject.NewCustomerPage;

public class TC_AddCustomerTest_003 extends BaseClass {
	@Test
	public void addcustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.Username(username);
		lp.Password(password);
		lp.login();
		NewCustomerPage addcust=new NewCustomerPage(driver);
		addcust.clickAddNewCustomer();
		log.info("providing customer details");
		addcust.custName("Pavan");
		addcust.custgender("male");
		addcust.custdob("10","15","1985");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("HYD");
		addcust.custstate("AP");
		addcust.custpinno("5000074");
		addcust.custtelephoneno("987890091");
		
		String email=randomstring()+"@gmail.com";
		addcust.custemailid(email);
		
		
		addcust.custsubmit();
		
		Thread.sleep(5000);
		
		
		log.info("validation started....");
		log.info("error log");
		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");
		
		if(res==true)
		{
			Assert.assertTrue(true);
			log.info("test case passed....");
			
		}
		else
		{
			log.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}
			
	}
	

	}


