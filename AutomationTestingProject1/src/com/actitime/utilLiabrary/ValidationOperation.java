package com.actitime.utilLiabrary;

import org.testng.Assert;

public class ValidationOperation 
{
	public static String verify(String expResult,String actResult)
	{
		try
		{
			Assert.assertEquals(expResult, actResult);
			return "pass";
		}
		catch(AssertionError rv1)
		{
			return "fail";
		}
	}
}
