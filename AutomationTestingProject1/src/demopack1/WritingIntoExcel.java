//writing data into excel
package demopack1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingIntoExcel 
{
	public static void main(String[] args) throws Exception 
	{
		FileInputStream fis= new FileInputStream("D:/Test Data/userdata.xlsx");
		Workbook w1= WorkbookFactory.create(fis);
		w1.getSheet("Sheet1").createRow(1).createCell(1).setCellValue("selenium");
		FileOutputStream fos= new FileOutputStream("D:/Test Data/userdata.xlsx");
		w1.write(fos);
		System.out.println("succes");
	}
}
