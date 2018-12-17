//testcase4
package demopack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class TestCase4 
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
		ff.findElement(By.linkText("Projects & Customers")).click();
		ff.findElement(By.xpath("//input[@value='Add New Project']")).click();
		
		WebElement rv2= ff.findElement(By.name("customerId"));
		Select s2=new Select(rv2);
		s2.selectByIndex(5);
		
		ff.findElement(By.name("name")).sendKeys("finacle.1");
		ff.findElement(By.name("createProjectSubmit")).click();
		
		String s=ff.findElement(By.className("successmsg")).getText();
		System.out.println(s);
		
		ff.findElement(By.className("logoutImg")).click();
		
	ff.close();
		
		
		
		
	}
}
