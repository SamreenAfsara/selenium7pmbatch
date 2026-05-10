package com.swaglabs.utils;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadData {
	
	XSSFSheet sheet;
	
	//constructor
	public ReadData(String filename)
	{
		  String filepath=".//src//main//resources//testdata//"+filename+".xlsx";	
		  
		  try
		  {
			  
			  FileInputStream instream = new FileInputStream(filepath);
			  XSSFWorkbook workbook= new XSSFWorkbook(instream);
			  sheet =workbook.getSheet("Sheet1");
			  
		  }
		  catch(Exception e)
		  {
			  e.printStackTrace();
		  }
	}
	
	//  specific cell
	public String getData(int rowno,int cellno)
	{
		return sheet.getRow(rowno).getCell(cellno).getStringCellValue();
	}
	
	//specific row
	public List<String> getData(int rowno)
	{
		
		int cellscount = sheet.getRow(rowno).getLastCellNum();
		System.out.println(cellscount);
		
		List<String> rowdata= new ArrayList<String>();
		for(int j=0;j<cellscount;j++)
		{
			String data=sheet.getRow(rowno).getCell(j).getStringCellValue();
			rowdata.add(data);
		}
		return rowdata;
	}
	
	//complete data
	
	public String[][]getData()
	{
		int lastrowno=sheet.getLastRowNum(); //it will return index
		System.out.println("Last row index no : "+lastrowno);
		int cellscount = sheet.getRow(0).getLastCellNum();
		System.out.println("Cell count : "+cellscount);
		
		String testdata[][] = new String[lastrowno][cellscount];
		
		int k=0,l;
		
		for(int i=1;i<=lastrowno;i++)
		{
			l=0;
			for(int j=0;j<cellscount;j++)
			{
				String data=sheet.getRow(i).getCell(j).getStringCellValue();
				testdata[k][l]=data;
				l++;
				
			}
			k++;
		}
		
		
		
		return testdata;
	}
	
	public static void main(String[] args) {
		ReadData read = new ReadData("loginpage");
		String data=read.getData(9, 1);
		System.out.println(data);
		
		List<String> rowdata=read.getData(9);
		System.out.println(rowdata);
		
		String testdata[][]=read.getData();
		
		for(int i=0;i<testdata.length;i++)
		{
			
			for(int j=0;j<testdata[i].length;j++)
			{
				System.out.print(testdata[i][j]+"  ");
				
			}
			System.out.println();
			
		}
	}
	
	
	

}
