package demo;

import org.openqa.selenium.firefox.FirefoxDriver;

public class DemoScript1 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","D:\\Application\\64bitAutomationSW\\geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.get("http://desktop-tp5sjto:81/login.do");
	}
}
