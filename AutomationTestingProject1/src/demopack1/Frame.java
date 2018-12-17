package demopack1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Frame 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		ff.get("file:///D:/html%20file/Parent.html");
		ff.findElement(By.name("Lang1")).click();
		
		ff.switchTo().frame(0);
		ff.findElement(By.name("Lang4")).click();
		ff.switchTo().defaultContent();
		
		ff.findElement(By.name("Lang2")).click();
		
		ff.switchTo().frame(1);
		ff.findElement(By.name("Lang5")).click();
		ff.switchTo().defaultContent();
		
		ff.findElement(By.name("Lang3")).click();
		
		ff.switchTo().frame(2);
		ff.findElement(By.name("Lang6")).click();
		ff.switchTo().defaultContent();
		
	}
}
