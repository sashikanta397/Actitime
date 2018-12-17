package demopack1;

import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScript1 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.get("https://www.google.com");
		ff.close();
	}
}
