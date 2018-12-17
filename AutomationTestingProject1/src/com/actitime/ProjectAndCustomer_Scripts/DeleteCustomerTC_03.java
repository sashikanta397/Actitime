package com.actitime.ProjectAndCustomer_Scripts;

import org.testng.annotations.Test;

import com.actitime.utilLiabrary.CommonLibrary;
import com.actitime.utilLiabrary.ExcelOperation;
import com.actitime.utilLiabrary.SuperTestScript;
import com.actitime.utilLiabrary.ValidationOperation;
import com.actitime.webpages.ActiveProjectsAndCustomerPage;
import com.actitime.webpages.EditCustomerInfoPage;
import com.actitime.webpages.LoginPage;
import com.actitime.webpages.OpenTaskPage;

public class DeleteCustomerTC_03 extends SuperTestScript
{
	@Test
	public void testDeleteCustomerTC_03() throws Exception
	{
		String username=ExcelOperation.readData("TC_03", 1, 0);
		String password =ExcelOperation.readData("TC_03", 1, 1);
		String customerName=ExcelOperation.readData("TC_03", 1, 2);
		String expectedResult=ExcelOperation.readData("TC_03", 1, 3);
		
		LoginPage lp=new LoginPage();
		OpenTaskPage otp=new OpenTaskPage();
		ActiveProjectsAndCustomerPage apcp=new ActiveProjectsAndCustomerPage();
		EditCustomerInfoPage ecip=new EditCustomerInfoPage();
		CommonLibrary cl=new CommonLibrary();
		
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickOnLoginButton();
		otp.clickOnProjectsAndCustomerLink();
		apcp.clickOnCustomerLink(customerName);
		ecip.clickOnDeleteThisCustomerButton();
		cl.selectOkButtonFromPopup();
		String actualResult=apcp.getsuccessMessage();
		
		String status=ValidationOperation.verify(expectedResult, actualResult);
		
		ExcelOperation.writeData("TC_03", 1, 4, actualResult);
		ExcelOperation.writeData("TC_03", 1, 5, status);
	}
}










