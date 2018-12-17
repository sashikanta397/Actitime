package com.actitime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilLiabrary.CommonLibrary;
import com.actitime.utilLiabrary.SuperTestScript;

public class AddNewProjectPage 
{
	@FindBy(name="customerId")
	private WebElement customerNameFromDropDown;
	
	@FindBy(name="name")
	private WebElement projectNameTextField;
	
	@FindBy(name="createProjectSubmit")
	private WebElement createProjectButton;
	
	public AddNewProjectPage()
	{
		PageFactory.initElements(SuperTestScript.driver, this);
	}
	
	public void selectCustomerFromDropdownByVisibleText(String cutomerName)
	{
		CommonLibrary cl=new CommonLibrary();
		cl.selectDropDownByVisibleText(customerNameFromDropDown, cutomerName);
	}
	
	public void enterProjectNameInProjectNameTextField(String projectName)
	{
		projectNameTextField.sendKeys(projectName);
	}
	
	public void clickOnCreateProjectButton()
	{
		createProjectButton.click();
	}
	
	
	
}
