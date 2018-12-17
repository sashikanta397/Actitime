package com.actitime.ProjectAndCustomer_Scripts;

import org.testng.annotations.Test;

import com.actitime.utilLiabrary.CommonLibrary;
import com.actitime.utilLiabrary.ExcelOperation;
import com.actitime.utilLiabrary.SuperTestScript;
import com.actitime.utilLiabrary.ValidationOperation;
import com.actitime.webpages.ActiveProjectsAndCustomerPage;
import com.actitime.webpages.AddNewCustomerPage;
import com.actitime.webpages.AddNewProjectPage;
import com.actitime.webpages.LoginPage;
import com.actitime.webpages.OpenTaskPage;

public class CreateProjectTC_04 extends SuperTestScript
{
	@Test
	public void testCreateProjectTC_04() throws Exception
	{
		String username=ExcelOperation.readData("TC_04", 1, 0);
		String password= ExcelOperation.readData("TC_04", 1, 1);
		String customerName=ExcelOperation.readData("TC_04", 1, 2);
		String projectName=ExcelOperation.readData("TC_04", 1, 3);
		String expectedResult=ExcelOperation.readData("TC_04", 1, 4);
		
		LoginPage lp=new LoginPage();
		OpenTaskPage otp=new OpenTaskPage();
		ActiveProjectsAndCustomerPage apcp=new ActiveProjectsAndCustomerPage();
		//AddNewCustomerPage ancp=new AddNewCustomerPage();
		AddNewProjectPage anpp=new AddNewProjectPage();
		//CommonLibrary cl=new CommonLibrary();
		
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickOnLoginButton();
		otp.clickOnProjectsAndCustomerLink();
		apcp.clickOnAddNewProjectButton();
		anpp.selectCustomerFromDropdownByVisibleText(customerName);
		anpp.enterProjectNameInProjectNameTextField(projectName);
		anpp.clickOnCreateProjectButton();
		String actualResult= apcp.getsuccessMessage();
		otp.clickOnLogoutButton();
		
		String status=ValidationOperation.verify(expectedResult, actualResult);
		
		ExcelOperation.writeData("TC_04", 1, 5, actualResult);
		ExcelOperation.writeData("TC_04", 1, 6, status);
		
		
		
	}
}
