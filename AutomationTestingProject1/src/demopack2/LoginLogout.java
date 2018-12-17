package demopack2;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class LoginLogout 
{
	@Test
	public void testLoginLogout()
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		ff.get("http://desktop-oo3v32t:81/login.do");
		ff.findElement(By.name("username")).sendKeys("admin");
		ff.findElement(By.name("pwd")).sendKeys("manager");
		ff.findElement(By.xpath("//input[@type='submit']")).click();
		
		String i= ff.getTitle();
		System.out.println(i);
		
		ff.findElement(By.className("logoutImg")).click();
		
		ff.close();
	}
}
