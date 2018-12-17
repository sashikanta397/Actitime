package com.actitime.utilLiabrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

abstract public class SuperTestScript 
{
	public static WebDriver driver;
	
	@BeforeTest
	public void preconfig() throws Exception
	{
		String browserType= ExcelOperation.readData("SuperTestData", 1, 0);
		String url= ExcelOperation.readData("SuperTestData", 1, 1);
		
		if(browserType.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",".\\Resource\\drivers\\geckodriver.exe");
			//System.setProperty("webdriver.gecko.driver","D:\\Application\\64bitAutomationSW\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		else if(browserType.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", ".\\Resource\\drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	@AfterTest
	public void postconfig()
	{
		driver.close();
	}
}













