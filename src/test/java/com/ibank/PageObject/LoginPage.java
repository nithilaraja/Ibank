package com.ibank.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//import org.seleniumhq.jetty9.util.log.Log;
import org.testng.Reporter;

import com.ibank.Testcases.BaseClass;

public class LoginPage extends BaseClass {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
@FindBy(name="uid")WebElement txtusername;
@FindBy(name="password")WebElement txtpassword;
@FindBy(name="btnLogin")WebElement txtLogin;
@FindBy(xpath="/html/body/div[3]/div/ul/li[10]/a")WebElement txtLogout;

public void Username(String username)
{
txtusername.sendKeys(username);
Reporter.log("Entered the username");
}
public void Password(String password)
{
txtpassword.sendKeys(password);
Reporter.log("Entered the Password");
log.debug("Sample DEBUG message");
log.error("Sample ERROR message");
log.info("Sample INFO message");
log.warn("Sample WARN message");
//Log.info("Entered the Password");
}

public void login()
{
	txtLogin.click();
	Reporter.log("Clicked the login button");
	//Log.setLog("Entered the Password");
}
public void submitlogout()
{
	txtLogout.click();
	Reporter.log("Clicked the login button");
	//Log.setLog("Entered the Password");
}
}