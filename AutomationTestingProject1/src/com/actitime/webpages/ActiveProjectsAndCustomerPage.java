package com.actitime.webpages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilLiabrary.SuperTestScript;

public class ActiveProjectsAndCustomerPage 
{
	@FindBy(xpath="//input[@value='Add New Customer']")
	private WebElement addNewCustomerButton;
	
	@FindBy(className="successmsg")
	private WebElement successMessage;
	
	@FindBy(xpath="//input[@value='Add New Project']")
	private WebElement addNewProjectButton;
	
	public ActiveProjectsAndCustomerPage()
	{
		PageFactory.initElements(SuperTestScript.driver, this);
	}
	
	public void clickOnAddNewCustomerButton()
	{
		addNewCustomerButton.click();
	}
	
	public void clickOnAddNewProjectButton()
	{
		addNewProjectButton.click();
	}
	
	public String getsuccessMessage()
	{
		return successMessage.getText();
	}
	
	public void clickOnCustomerLink(String customerName)
	{
		SuperTestScript.driver.findElement(By.linkText(customerName)).click();
	}
}





