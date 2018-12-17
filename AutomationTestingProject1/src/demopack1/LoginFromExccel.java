package demopack1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.firefox.FirefoxDriver;

public class LoginFromExccel 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		
		FileInputStream fis= new FileInputStream("D:/Test Data/userdata.xlsx");
		Workbook w1= WorkbookFactory.create(fis);
		String url= w1.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		String username=w1.getSheet("Sheet2").getRow(1).getCell(1).getStringCellValue();
		String password= w1.getSheet("Sheet2").getRow(1).getCell(2).getStringCellValue();
		
		ff.get(url);
		ff.findElement(By.name("username")).sendKeys(username);
		ff.findElement(By.name("pwd")).sendKeys(password);
		ff.findElement(By.xpath("//input[@type='submit']")).click();
		ff.findElement(By.className("logoutImg")).click();
		
		
	}
}
