package com.actitime.utilLiabrary;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.Select;

public class CommonLibrary 
{
	public void selectDropDownByIndex(WebElement dropDownLocation,int indexNo)
	{
		Select s1= new Select(dropDownLocation);
		s1.selectByIndex(indexNo);
	}
	
	public void selectDropDownByVisibleText(WebElement dropDownLocation, String visibleText)
	{
		Select s1=new Select(dropDownLocation);
		s1.selectByVisibleText(visibleText);
	}
	
	public void selctDropDownByValue(WebElement dropDownLocation, String value)
	{
		Select s1= new Select(dropDownLocation);
		s1.selectByValue(value);
	}
	
	public void selectOkButtonFromPopup()
	{
		SuperTestScript.driver.switchTo().alert().accept();
	}
	
	public void selectCancelButtonFromPopup()
	{
		SuperTestScript.driver.switchTo().alert().dismiss();
	}
	
	public String getTheTextFromPopup()
	{
		return SuperTestScript.driver.switchTo().alert().getText();
	}
	
	public void takeScreenShot(String i)
	{
		EventFiringWebDriver rv1=new EventFiringWebDriver(SuperTestScript.driver);
		File source=rv1.getScreenshotAs(OutputType.FILE);
		File target= new File(".//Resource//Failed TestScripts Screenshots"+i+".jpg");
		try
		{
			FileUtils.moveFile(source, target);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
}
































