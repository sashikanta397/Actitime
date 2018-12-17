package demopack1;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestScript2 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.get("file:///D:/html%20file/Untitled1.html");
		ff.findElement(By.id("un")).sendKeys("litu");
		ff.findElement(By.name("pwd")).sendKeys("litu397");
		ff.findElement(By.className("login")).click();
		//ff.close();
	}
}
