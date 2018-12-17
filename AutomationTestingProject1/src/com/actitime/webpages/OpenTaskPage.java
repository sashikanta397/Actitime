package com.actitime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilLiabrary.SuperTestScript;

public class OpenTaskPage 
{
	@FindBy(className="logoutImg")
	private WebElement logoutButton;
	
	@FindBy(linkText="Projects & Customers")
	private WebElement projectsAndCustomerLink;
	
	public OpenTaskPage()
	{
		PageFactory.initElements(SuperTestScript.driver, this);
	}
	
	public String getTitleOfOpenTaskPage()
	{
		return SuperTestScript.driver.getTitle();
	}
	
	public void clickOnProjectsAndCustomerLink()
	{
		projectsAndCustomerLink.click();
	}
	
	public void clickOnLogoutButton()
	{
		logoutButton.click();
	}
}
