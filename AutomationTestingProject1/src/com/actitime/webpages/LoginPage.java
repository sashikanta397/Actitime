package com.actitime.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilLiabrary.SuperTestScript;

public class LoginPage 
{
	@FindBy(name="username")
	private WebElement userNameTextField;
	
	@FindBy(name="pwd")
	private WebElement passwordTextField;
	
	@FindBy(xpath="//input[@type='submit']")
	private WebElement loginButton;
	
	public LoginPage()
	{
		PageFactory.initElements(SuperTestScript.driver, this);
	}
	
	public void enterUserName(String username)
	{
		userNameTextField.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		passwordTextField.sendKeys(password);
	}
	
	public void clickOnLoginButton()
	{
		loginButton.click();
	}
}

















