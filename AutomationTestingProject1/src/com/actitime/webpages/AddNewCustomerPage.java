package com.actitime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilLiabrary.SuperTestScript;

public class AddNewCustomerPage 
{
	@FindBy(name="name")
	private WebElement customerNameTextField;
	
	@FindBy(name="createCustomerSubmit")
	private WebElement createCustomerButton;
	
	public AddNewCustomerPage()
	{
		PageFactory.initElements(SuperTestScript.driver, this);
	}
	
	public void enterNameInCustomerNameTextField(String customerName)
	{
		customerNameTextField.sendKeys(customerName);
	}
	
	public void clickOnCreateCustomerButton()
	{
		createCustomerButton.click();
	}
	
}















