package demopack1;

import java.io.File;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class LoginScreenshot 
{
	public static void main(String[] args) throws Exception 
	{
		System.setProperty("webdriver.gecko.driver","D:/64bitAutomationSW/geckodriver.exe");
		FirefoxDriver ff= new FirefoxDriver();
		ff.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS );
		
		FileInputStream fis= new FileInputStream("D:/Test Data/userdata.xlsx");
		Workbook w1= WorkbookFactory.create(fis);
		String url= w1.getSheet("Sheet2").getRow(1).getCell(0).getStringCellValue();
		ff.get(url);
		
		EventFiringWebDriver rv1= new EventFiringWebDriver(ff);
		File f1= rv1.getScreenshotAs(OutputType.FILE);
		File f2= new File("D:/Test Data/Sceenshot/Login.jpg");
		FileUtils.moveFile(f1, f2);
		
		
	}
}
