//TEST CASE4 FROM EXCEL
package demopack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class ExcelTestCase4 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff=new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		FileInputStream fis= new FileInputStream("D:/Test Data/userdata.xlsx");
		Workbook w1= WorkbookFactory.create(fis);
		
		String url= w1.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();//URL
		ff.get(url);
		
		String userName= w1.getSheet("Sheet2").getRow(1).getCell(1).getStringCellValue();//USERNAME
		ff.findElement(By.name("username")).sendKeys(userName);
		
		String password= w1.getSheet("Sheet2").getRow(1).getCell(2).getStringCellValue();//PASSWORD
		ff.findElement(By.name("pwd")).sendKeys(password);
		
		ff.findElement(By.xpath("//input[@type='submit']")).click();//LOGIN BOTTON
		ff.findElement(By.linkText("Projects & Customers")).click();//CLICK ON PROJRCT AND CUSTOMER
		ff.findElement(By.xpath("//input[@value='Add New Project']")).click();//CLICK ON ADD NEW PROJECT
		
		WebElement rv2= ff.findElement(By.name("customerId"));
		Select s2=new Select(rv2);
		String customer= w1.getSheet("Sheet2").getRow(2).getCell(3).getStringCellValue();
		s2.selectByVisibleText(customer);//SELECTING CUSOOMER FROM DROPDOWN
		
		String projectName= w1.getSheet("Sheet2").getRow(2).getCell(4).getStringCellValue();
		ff.findElement(By.name("name")).sendKeys(projectName);//ENTER PROJECT NAME
		ff.findElement(By.name("createProjectSubmit")).click();//CLICK ON CREATE PROJECT BOTTON
		
		String s=ff.findElement(By.className("successmsg")).getText();//GET SECCESS MSG
		w1.getSheet("Sheet2").getRow(2).createCell(5).setCellValue(s);
		FileOutputStream fos= new FileOutputStream("D:/Test Data/userdata.xlsx");
		w1.write(fos);
		
		
		
		
		
		
		
		
		
		
	}
}
