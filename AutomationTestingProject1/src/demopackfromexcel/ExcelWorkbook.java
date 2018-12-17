package demopackfromexcel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelWorkbook 
{
	public static String readData(String SheetName,int rowNum,int cellNum) throws Exception
	{
		FileInputStream fis= new FileInputStream("D:/Test Data/userdata.xlsx");
		Workbook w1= WorkbookFactory.create(fis);
		String s= w1.getSheet(SheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return s;
	}
	
	public static void writeData(String SheetName,int rowNum,int cellNum,String value) throws Exception 
	{
		FileInputStream fis= new FileInputStream("D:/Test Data/userdata.xlsx");
		Workbook w1= WorkbookFactory.create(fis);
		w1.getSheet(SheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
		FileOutputStream fos= new FileOutputStream("D:/Test Data/userdata.xlsx");
		w1.write(fos);
	}
}
