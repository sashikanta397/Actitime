package demopack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;


public class DropDown 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ff.get("http://desktop-oo3v32t:81/login.do");
		ff.findElement(By.name("username")).sendKeys("admin");
		ff.findElement(By.name("pwd")).sendKeys("manager");
		ff.findElement(By.xpath("//input[@type='submit']")).click();
			Thread.sleep(2000);
		Select dd= new Select(ff.findElement(By.name("customerProject.shownCustomer")));
		dd.selectByIndex(3);
		ff.findElement(By.name("searchTasks")).click();
		ff.findElement(By.className("logoutImg")).click();
		ff.close();
	}
}
