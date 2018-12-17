package com.actitime.ProjectAndCustomer_Scripts;

import org.testng.annotations.Test;

import com.actitime.utilLiabrary.ExcelOperation;
import com.actitime.utilLiabrary.SuperTestScript;
import com.actitime.utilLiabrary.ValidationOperation;
import com.actitime.webpages.ActiveProjectsAndCustomerPage;
import com.actitime.webpages.AddNewCustomerPage;
import com.actitime.webpages.LoginPage;
import com.actitime.webpages.OpenTaskPage;

public class CreateCustomerTC_02 extends SuperTestScript
{
	@Test
	public void testCreateCustomerTC_02() throws Exception
	{
		String username=ExcelOperation.readData("TC_02", 1, 0);
		String password=ExcelOperation.readData("TC_02", 1, 1);
		String customerName=ExcelOperation.readData("TC_02", 1, 2);
		String expectedResult=ExcelOperation.readData("TC_02", 1, 3);
		
		LoginPage lp=new LoginPage();
		OpenTaskPage otp=new OpenTaskPage();
		ActiveProjectsAndCustomerPage apcp=new ActiveProjectsAndCustomerPage();
		AddNewCustomerPage ancp=new AddNewCustomerPage();
		
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickOnLoginButton();
		otp.clickOnProjectsAndCustomerLink();
		apcp.clickOnAddNewCustomerButton();
		ancp.enterNameInCustomerNameTextField(customerName);
		ancp.clickOnCreateCustomerButton();
		String actualResult= apcp.getsuccessMessage();
		otp.clickOnLogoutButton();
		
		String status=ValidationOperation.verify(expectedResult, actualResult);
		
		ExcelOperation.writeData("TC_02", 1, 4, actualResult);
		ExcelOperation.writeData("TC_02", 1, 5, status);
	
	}
}
