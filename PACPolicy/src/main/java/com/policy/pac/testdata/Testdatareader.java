package com.policy.pac.testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Testdatareader {

	public static Object[][] getdata(int index)
	{
	String excelFilePath = "C:\\Users\\M1056369\\eclipse-workspace\\PACPolicy\\src\\main\\java\\com\\policy\\pac\\testdata\\CreatePolicy.xlsx";
    FileInputStream inputStream = null;
	try {
		inputStream = new FileInputStream(new File(excelFilePath));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
     
    Workbook workbook = null;
	try {
		workbook = new XSSFWorkbook(inputStream);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	Sheet sheet = workbook.getSheetAt(index);
	Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
	
	for(int i=0;i<sheet.getLastRowNum();i++) 
	{
		for(int k=0;k<sheet.getRow(0).getLastCellNum();k++)
		{
			data[i][k]=sheet.getRow(i+1).getCell(k).toString();
			System.out.println("Data is : "+data[i][k]);
		}
		System.out.println();
	}
	return data;

}
	
	public static void main(String[] args) {
		Testdatareader.getdata(0);

	}

}
