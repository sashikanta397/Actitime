package com.actitime.ProjectAndCustomer_Scripts;

import org.testng.annotations.Test;

import com.actitime.utilLiabrary.ExcelOperation;
import com.actitime.utilLiabrary.SuperTestScript;
import com.actitime.utilLiabrary.ValidationOperation;
import com.actitime.webpages.LoginPage;
import com.actitime.webpages.OpenTaskPage;

public class LoginLogoutTC_01 extends SuperTestScript
{
	@Test
	public void testLoginLogoutTC_01() throws Exception
	{
		//step-1(Retrive necessery data from excel)
		String username=ExcelOperation.readData("TC_01", 1, 0);
		String password=ExcelOperation.readData("TC_01", 1, 1);
		String expectedResult=ExcelOperation.readData("TC_01", 1, 2);
		
		//step-2(create all necessery objects)
		LoginPage lp=new LoginPage();
		OpenTaskPage otp=new OpenTaskPage();
		
		//step-3(convert testcase into testscript)
		lp.enterUserName(username);
		lp.enterPassword(password);
		lp.clickOnLoginButton();
		String actualResult=otp.getTitleOfOpenTaskPage();
		otp.clickOnLogoutButton();
		
		//step-4(compare expectedRessult with actualResult)
		String status=ValidationOperation.verify(expectedResult, actualResult);
		
		//step-5(write data into Excel)
		ExcelOperation.writeData("TC_01", 1, 3, actualResult);
		ExcelOperation.writeData("TC_01", 1, 4, status);
	}
}










