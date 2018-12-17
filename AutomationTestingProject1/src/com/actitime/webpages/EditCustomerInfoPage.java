package com.actitime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilLiabrary.SuperTestScript;

public class EditCustomerInfoPage 
{
	@FindBy(xpath="//input[@value='Delete This Customer']")
	private WebElement deleteThisCustomerButton;
	
	public EditCustomerInfoPage()
	{
		PageFactory.initElements(SuperTestScript.driver, this);
	}
	
	public void clickOnDeleteThisCustomerButton()
	{
		deleteThisCustomerButton.click();
	}
}
