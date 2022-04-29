package com.ibank.Testcases;

import java.io.IOException;
//import java.util.logging.Logger;
import java.util.concurrent.TimeUnit;

//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import com.ibank.PageObject.LoginPage;
import com.ibank.utilities.XLUtils;

//import Util.ExcelDatap;

public class TC_LoginDDT_002 extends BaseClass 
{
	@Test(dataProvider="LoginData")
	public void loginDDT(String username,String password) throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.Username(username);
		lp.Password(password);
		lp.login();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		if(isAlert()==true)
		{
			log.info("alert due to failed case");
			driver.switchTo().alert().accept();//when failed aler will come
			driver.switchTo().defaultContent();
			Assert.assertTrue(false);
			captureScreen(driver,"Logintest");
		}
		else
		{
			Assert.assertTrue(true);
			lp.submitlogout();
			Thread.sleep(2000);
			driver.switchTo().alert().accept();//logout alert
			driver.switchTo().defaultContent();
			log.info("Success logged out successfully");
		}
	}
	public boolean isAlert()
	{
		try
		{
		driver.switchTo().alert().accept();
		
		return true;
		}
		catch(NoAlertPresentException e)
		{
			return false;
		}
	}
	@DataProvider(name="LoginData")
	String [][] getData()throws IOException
	{
		String path=System.getProperty("user.dir")+"/src/test/java/com/ibank/TestData/LoginData.xlsx";
	int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path,"Sheet1",1);
		
		String logindata[][]=new String[rownum][colcount];
		for(int i=1;i<=rownum;i++)
		{
			for(int j=0;j<colcount;j++)
			{
				logindata[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
			}
		}
		return logindata;
			}
		
	

}
