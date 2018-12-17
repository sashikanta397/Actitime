package com.actitime.utilLiabrary;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelOperation 
{
	public static String readData(String sheetName,int rowNum,int cellNum) throws Exception
	{
		try 
		{
			FileInputStream fis= new FileInputStream(".\\Resource\\TestData\\UserData.xlsx");
			//FileInputStream fis= new FileInputStream("D:\\Test Data\\UserData.xlsx");
			Workbook w1= WorkbookFactory.create(fis);
			String s= w1.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
			return s;
		}
		catch(Exception rv1)
		{
			return "";
		}
	}

	public static void writeData(String sheetName,int rowNum,int cellNum,String value) throws Exception 
	{
		try
		{
			FileInputStream fis= new FileInputStream(".\\Resource\\TestData\\UserData.xlsx");
			//FileInputStream fis= new FileInputStream("D:\\Test Data\\UserData.xlsx");
			Workbook w1= WorkbookFactory.create(fis);
			w1.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);
			FileOutputStream fos= new FileOutputStream(".\\Resource\\TestData\\UserData.xlsx");
			//FileOutputStream fos= new FileOutputStream("D:\\Test Data\\UserData.xlsx");
			w1.write(fos);
		}
		catch(Exception rv1)
		{
			
		}
	}
}
