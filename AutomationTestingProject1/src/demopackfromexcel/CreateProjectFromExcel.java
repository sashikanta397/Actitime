package demopackfromexcel;

import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class CreateProjectFromExcel 
{
	@Test
	public void createProjectFromExcel() throws Exception
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
		String customer= w1.getSheet("Sheet2").getRow(5).getCell(3).getStringCellValue();
		s2.selectByVisibleText(customer);//SELECTING CUSOOMER FROM DROPDOWN
		
		String projectName= w1.getSheet("Sheet2").getRow(5).getCell(4).getStringCellValue();
		ff.findElement(By.name("name")).sendKeys(projectName);//ENTER PROJECT NAME
		ff.findElement(By.name("createProjectSubmit")).click();//CLICK ON CREATE PROJECT BOTTON
		ff.findElement(By.className("logoutImg")).click();
		
		ff.close();
	}
}
