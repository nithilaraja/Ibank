package com.ibank.Testcases;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ibank.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.implementation.FieldAccessor.PropertyConfigurable;

public class BaseClass {
	ReadConfig readconfig=new ReadConfig();
public String baseURL=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword();
public static WebDriver driver;
public static Logger log = LogManager.getLogger(BaseClass.class);

@Parameters("browser")
@BeforeClass
public void setup(String br) throws Exception
{
	if(br.equalsIgnoreCase("chrome"))
	{
	WebDriverManager.chromedriver().setup();
	
	 driver=new ChromeDriver();
	 driver.manage().window().maximize(); 
	}
	else if(br.equalsIgnoreCase("firefox"))
	{
	WebDriverManager.firefoxdriver().setup();
	
	 driver=new FirefoxDriver();
	 driver.manage().window().maximize(); 
	}
	else if(br.equalsIgnoreCase("Edge"))
	{
	WebDriverManager.edgedriver().setup();
	
	 driver=new EdgeDriver();
	 driver.manage().window().maximize(); 
	} 
	else{
		//If no browser passed throw exception
		throw new Exception("Browser is not correct");
	}
	//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.get(baseURL);
}
@AfterClass
public void browserclose()
{
	driver.quit();
}
public void captureScreen(WebDriver driver, String tname) throws IOException {
	TakesScreenshot ts = (TakesScreenshot) driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
	FileUtils.copyFile(source, target);
	System.out.println("Screenshot taken");
}
public String randomstring()
{
	String generatedstring=RandomStringUtils.randomAlphabetic(8);
	return(generatedstring);
}
public String randomNum()
{
	String generatedstring=RandomStringUtils.randomNumeric(4);
	return(generatedstring);
}

}
