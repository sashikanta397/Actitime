package demo;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HAndlingChildWIndow 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","D:\\Application\\64bitAutomationSW\\geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.get("http://desktop-tp5sjto:81/login.do");
		ff.findElement(By.name("username")).sendKeys("admin");
		
		ff.findElement(By.name("pwd")).sendKeys("manager");
			
		ff.findElement(By.xpath("//input[@type='submit']")).click();
		ff.findElement(By.linkText("Reports")).click();
		ff.findElement(By.xpath("//img[@alt='Click Here to Pick up the date']")).click();
		Set<String> rv1=ff.getWindowHandles();
		java.util.Iterator<String> i1=rv1.iterator();
		String mainWindow=i1.next();
		String childWindow=i1.next();
		ff.switchTo().window(childWindow);
		ff.findElement(By.xpath("//span[text()='27']")).click();
	}
}
