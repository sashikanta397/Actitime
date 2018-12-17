package demo;

import java.util.Set;

import org.apache.bcel.generic.Select;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.gargoylesoftware.htmlunit.javascript.host.Iterator;

public class CreateGmailAccount 
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","D:\\Application\\64bitAutomationSW\\geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.get("https://www.google.com/intl/en-GB/gmail/about/");
		ff.findElement(By.linkText("CREATE AN ACCOUNT")).click();
		Set<String> rv1=ff.getWindowHandles();
		java.util.Iterator<String> i1=rv1.iterator();
		String mainWindow=i1.next();
		String childWindow=i1.next();
		ff.switchTo().window(childWindow);
		//ff.get("https://accounts.google.com/signup/v2/webcreateaccount?service=mail&continue=http%3A%2F%2Fmail.google.com%2Fmail%2F%3Fpc%3Dcarousel-about-en&flowName=GlifWebSignIn&flowEntry=SignUp");
		
		WebDriverWait rv=new WebDriverWait(ff,30);
		rv.until(ExpectedConditions.elementToBeClickable(ff.findElement(By.id("firstName")).sendKeys("Sashikanta");))
		//ff.findElement(By.id("firstName")).sendKeys("Sashikanta");
		ff.findElement(By.id("lastName")).sendKeys("Behera");
		ff.findElement(By.name("Passwd")).sendKeys("litu12345");
		ff.findElement(By.name("ConfirmPasswd")).sendKeys("litu12345");
		ff.findElement(By.className("RveJvd snByac")).click();
		ff.findElement(By.id("day")).sendKeys("12");
		WebElement rv1= ff.findElement(By.id("month"));
		org.openqa.selenium.support.ui.Select s1=new org.openqa.selenium.support.ui.Select(rv1);
		s1.selectByVisibleText("March");
		ff.findElement(By.id("year")).sendKeys("1995");
		WebElement rv2= ff.findElement(By.id("gender"));
		org.openqa.selenium.support.ui.Select s2=new org.openqa.selenium.support.ui.Select(rv2);
		s1.selectByVisibleText("Male");
		ff.findElement(By.className("RveJvd snByac")).click();
		
		
		
		
	}
}
