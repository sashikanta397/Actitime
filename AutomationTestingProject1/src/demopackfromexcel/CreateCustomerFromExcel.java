package demopackfromexcel;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class CreateCustomerFromExcel 
{
	
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		
		String url= ExcelWorkbook.readData("Sheet4", 1, 0);
		String username= ExcelWorkbook.readData("Sheet4", 1, 1);
		String password= ExcelWorkbook.readData("Sheet4", 1, 2);
		String customerName= ExcelWorkbook.readData("Sheet4", 2, 3);
		
		ff.get(url);
		ff.findElement(By.name("username")).sendKeys(username);
		ff.findElement(By.name("pwd")).sendKeys(password);
		ff.findElement(By.xpath("//input[@type='submit']")).click();
		ff.findElement(By.linkText("Projects & Customers")).click();
		ff.findElement(By.xpath("//input[@value='Add New Customer']")).click();			
		ff.findElement(By.name("name")).sendKeys(customerName);			
		ff.findElement(By.name("createCustomerSubmit")).click();
		
		
		ff.findElement(By.className("logoutImg")).click();
		
		ff.close();
	}
}
