package demopack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.actitime.utilLiabrary.ExcelOperation;

import demopackfromexcel.ExcelWorkbook;

public class PrintTitleToExcel 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		
		
		String url= ExcelOperation.readData("Sheet5", 1, 0);
		String username=  ExcelOperation.readData("Sheet5", 1, 1);
		String password=  ExcelOperation.readData("Sheet5", 1, 2);
		
		ff.get(url);
		ff.findElement(By.name("username")).sendKeys(username);
		ff.findElement(By.name("pwd")).sendKeys(password);
		ff.findElement(By.xpath("//input[@type='submit']")).click();
		
		String s= ff.getTitle();
		
		ExcelOperation.writeData("Sheet5", 1, 4, s);
		
	
		
	}
}
