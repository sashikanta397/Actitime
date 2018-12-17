//tastcase-6
package demopack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class PopupJavaSript 
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		ff.get("http://desktop-oo3v32t:81/login.do");
		ff.findElement(By.name("username")).sendKeys("admin");
		
		ff.findElement(By.name("pwd")).sendKeys("manager");
			
		ff.findElement(By.xpath("//input[@type='submit']")).click();
			
		ff.findElement(By.linkText("Projects & Customers")).click();
			
		ff.findElement(By.linkText("RAJU4")).click();
		
		ff.findElement(By.xpath("//input[@value='Delete This Customer']")).click();
		
		Thread.sleep(2000);
		
		Alert rv1= ff.switchTo().alert();
		String s= rv1.getText();
		rv1.accept();
		System.out.println(s);
		
		String p = ff.findElement(By.className("successmsg")).getText();
		System.out.println(p);
		
		
	}
}
