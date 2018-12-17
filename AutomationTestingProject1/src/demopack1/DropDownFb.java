//testcase-5
package demopack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownFb 
{
	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		ff.get("https://www.facebook.com/");
		
		WebElement rv1= ff.findElement(By.id("day"));
		Select s1=new Select(rv1);
		s1.selectByVisibleText("18");
		
		WebElement rv2= ff.findElement(By.id("month"));
		Select s2=new Select(rv2);
		s2.selectByIndex(5);
		
		WebElement rv3= ff.findElement(By.id("year"));
		Select s3=new Select(rv3);
		s3.selectByVisibleText("1995");

	}
}
